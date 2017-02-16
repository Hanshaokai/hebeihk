package cn.huischool.huixiao.fragments.mine;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.mine.changeinforacticitys.SelectPicActivity;
import cn.huischool.huixiao.common.utils.ToolFile;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseFragment;

/**
 * Created by ${han} on 2016/7/19.
 */
public class SelectPicFragment extends BaseFragment {

    private TextView tv_mine_chagepic_album;
    private TextView tv_mine_chagepic_takephoto;
    private TextView tv_mine_chagepic_cancle;

    private static final int REQUEST_PHOTOALBUM = 1;// 相册
    private static final int REQUEST_PHOTOGRAPH = 2;// 照相
    private static final int REQUEST_PHOTOCROP = 3;// 裁剪
    private Uri cameraUri; // 照相后图片保存路径



    private Uri cropImageUri;
    private SelectPicActivity myActivity;
    private Intent lastIntent;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = (SelectPicActivity) baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_mine_changepic_select, null, false);
        tv_mine_chagepic_album = (TextView) view.findViewById(R.id.tv_mine_chagepic_album);
        tv_mine_chagepic_takephoto = (TextView) view.findViewById(R.id.tv_mine_chagepic_takephoto);
        tv_mine_chagepic_cancle = (TextView) view.findViewById(R.id.tv_mine_chagepic_cancle);
        lastIntent = myActivity.getIntent();

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        setlistener();
    }

    private void setlistener() {

        tv_mine_chagepic_album.setOnClickListener(this);
        tv_mine_chagepic_takephoto.setOnClickListener(this);
        tv_mine_chagepic_cancle.setOnClickListener(this);
    }

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {

            case R.id.tv_mine_chagepic_album:
                Intent openAlbumIntent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openAlbumIntent, 1);
                break;

            case R.id.tv_mine_chagepic_cancle:
                removeFragment();
                break;
            case R.id.tv_mine_chagepic_takephoto:
                try {
                    Intent openCameraIntent = new Intent(
                            MediaStore.ACTION_IMAGE_CAPTURE);

                    File file = null;

                    file = ToolFile.getImageFile(myActivity);
                    if (file != null) {
                        cameraUri = Uri.fromFile(file);
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, cameraUri);
                        startActivityForResult(openCameraIntent, 2);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == myActivity.RESULT_CANCELED)
            return;
        switch (requestCode) {
            case 2:// 拍照返回
                startPhotoZoom(cameraUri);
                LogUtil.d("拍照返回");
                break;
            case 1:// 相册返回
                LogUtil.d("相册返回");
                if (data != null) {
                    Uri uri = data.getData();
                    if (uri != null)
                        startPhotoZoom(uri);
                }
                break;
            case 3:// 裁剪返回
                LogUtil.d("裁剪返回");
                if (data != null)
                    setPicToView(data);
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /*附加选项    数据类型    描述
    crop    String  发送裁剪信号
    aspectX int X方向上的比例
    aspectY int Y方向上的比例
    outputX int 裁剪区的宽
    outputY int 裁剪区的高
    scale   boolean 是否保留比例
    return-data boolean 是否将数据保留在Bitmap中返回
    data    Parcelable  相应的Bitmap数据
    circleCrop  String  圆形裁剪区域？
    MediaStore.EXTRA_OUTPUT ("output")  URI 将URI指向相应的file:///...，详见代码示例  */
    private void startPhotoZoom(Uri uri) {
        try {
            // 获取系统时间 然后将裁剪后的图片保存至指定的文件夹
            cropImageUri = Uri.fromFile(ToolFile.getImageFile(myActivity));
            Intent intent = new Intent("com.android.camera.action.CROP");
            // 照片URL地址
            intent.setDataAndType(uri, "image/*");
            intent.putExtra("crop", "true");

            // aspectX aspectY 是宽高的比例
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);

            // outputX,outputY 是剪裁图片的宽高
            intent.putExtra("outputX", 150);
            intent.putExtra("outputY", 150);
            intent.putExtra("return-data", false);
            intent.putExtra("scale", true);
            // 输出路径
            intent.putExtra(MediaStore.EXTRA_OUTPUT, cropImageUri);
            // 输出格式
            intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
            // 不启用人脸识别
            intent.putExtra("noFaceDetection", false);
            //   intent.putExtra("return-data", false);
            startActivityForResult(intent, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param
     */
    private void setPicToView(Intent data) {
        FileInputStream fis;
        String IMGNAME = "imgName";
        String IMGBYTES = "imgBytes";
        String IMGPATH = "imgpath";
        String ACTTAG = "actTag";

        String fileName = cropImageUri.getPath();
        LogUtil.d(fileName + "图片路径");
        try {
            fis = new FileInputStream(fileName);


            Bitmap bitmap = BitmapFactory.decodeStream(fis); // /把流转化为Bitmap图片
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] bitmapByte = baos.toByteArray();
            LogUtil.d(bitmapByte.toString());
            lastIntent.putExtra(IMGBYTES, bitmapByte);

            lastIntent.putExtra(IMGPATH, fileName);
            myActivity.setResult(myActivity.RESULT_OK, lastIntent);

            removeFragment();
        }  catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * @param x              图像的宽度
     * @param y              图像的高度
     * @param image          源图片
     * @param outerRadiusRat 圆角的大小
     * @return 圆角图片
     */
    public static Bitmap createFramedPhoto(int x, int y, Bitmap image, float outerRadiusRat) {
        // 根据源文件新建一个darwable对象
        Drawable imageDrawable = new BitmapDrawable(image);

        // 新建一个新的输出图片
        Bitmap output = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        // 新建一个矩形
        RectF outerRect = new RectF(0, 0, x, y);

        // 产生一个红色的圆角矩形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        canvas.drawRoundRect(outerRect, outerRadiusRat, outerRadiusRat, paint);

        // 将源图片绘制到这个圆角矩形上
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        imageDrawable.setBounds(0, 0, x, y);
        canvas.saveLayer(outerRect, paint, Canvas.ALL_SAVE_FLAG);
        imageDrawable.draw(canvas);
        canvas.restore();

        return output;
    }

}