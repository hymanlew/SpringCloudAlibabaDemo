package com.hyman.common.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 各种海报图
 * @author: hyman
 * @date: 2020/4/22
 */
public class PosterUtils {

    public static void main(String[] args) throws IOException {
        List<String> workTimeArr = new LinkedList<>();
        workTimeArr.add("03:00-07:00");
        workTimeArr.add("17:00-00:00");
        drawLinePoster("天津-北京", "自行车",
                "天津市天津市东丽", "北京市天津-北京/不返仓", "72000",
                "9.61米厢货", workTimeArr, "", "");
    }

    /**
     * 供应链(线路)海报图
     *
     * @param lineName       线路名称
     * @param goodsTypes     货物类型
     * @param repLocation    仓库位置
     * @param deliveryName   配送区域
     * @param preIncome      预计月收入
     * @param carTypes       车型
     * @param workTimeArr    工作时间
     * @param qrCodeImageUrl 二维码URL
     * @param backImageUrl   背景图URL
     */
    public static File drawLinePoster( String lineName, String goodsTypes, String repLocation, String deliveryName,
                                      String preIncome, String carTypes, List<String> workTimeArr, String qrCodeImageUrl,
                                      String backImageUrl) throws IOException {
        //获取要生成的底图
        Image backImage = ImageIO.read(new URL(backImageUrl));
       // System.out.println("底图宽："+backImage.getWidth(null) + "  高："+backImage.getHeight(null));
        //Image backImage = ImageIO.read(new File("/Users/hyman/Documents/otherProjects/test/model.jpg"));
        //定义全局字体风格，方便修改
        final String fontStyle = "微软雅黑";

        int backHeight = backImage.getHeight(null);
        int backWidth = backImage.getWidth(null);

        //构造一个类型为预定义图像类型之一的 BufferedImage。
        BufferedImage image = new BufferedImage(backWidth, backHeight, BufferedImage.TYPE_INT_RGB);
        //绘制合成图像
        Graphics2D g = image.createGraphics();

        //渲染优化，消除锯齿,要不然文字会不清晰，感官很差
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //添加背景图片
        g.drawImage(backImage, 0, 0, backWidth, backHeight, null);

        //开始往图片上写字
        //第一行的 运输类型/货主信息
        String typeCustomer =  lineName;
        //参数变量化,第一行定义一个变量，是距离顶部最合适的距离，方便下面调用。(下同)
        int firstDistance = 120;
        int divOffset = 13;
        if (typeCustomer.length() <= divOffset) {
            firstDistance = 140;
        }
        //第一行的字体size，字体颜色，字号，倾斜度 etc...(下同)
        int firstFontSize = 51;
        g.setColor(Color.WHITE);
        g.setFont(new Font(fontStyle, Font.ITALIC + Font.BOLD, firstFontSize));
        drawOneString(g, backWidth, firstDistance, typeCustomer);

        //第二行 预估收入
        //距离顶部的距离
        int secondDistance = 430;
        //字体属性
        int secondFontSize = 35;
        g.setColor(new Color(252, 254, 252));
        g.setFont(new Font(fontStyle, Font.PLAIN + Font.BOLD, secondFontSize));
        preIncome = "预估月收入:" + preIncome + "元";
        g.drawString(preIncome, (backWidth - g.getFontMetrics().stringWidth(preIncome)) / 2, secondDistance);

        //第三行 车型
        int thirdDistance = secondDistance + 76;
        int thirdFontSize = 32;
        g.setColor(Color.BLACK);
        g.setFont(new Font(fontStyle, Font.PLAIN, thirdFontSize));
        carTypes = "车型:  " + carTypes;
        g.drawString(carTypes, (backWidth - g.getFontMetrics().stringWidth(carTypes)) / 2, thirdDistance);

        //定义一个靠左的距离第3、4、6、7行会用到
        int left = 162;
        int fontSize = 26;
        //第四行 仓库位置
        int fourDistance = thirdDistance + 81;
        g.setColor(Color.BLACK);
        //字号size和上一行保持一致
        g.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
        repLocation = "仓库位置: " + repLocation;
        if (repLocation.length() > 18) {
            repLocation = repLocation.substring(0, 18);
        }
        g.drawString(repLocation, left, fourDistance);

        //第五行 配送位置
        int fiveDistance = fourDistance + 92;
        g.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
        deliveryName = "配送区域: " + deliveryName;
        if (deliveryName.length() > 18) {
            deliveryName = deliveryName.substring(0, 18);
        }
        g.drawString(deliveryName, left, fiveDistance);

        //第六行 货物类型
        int sixDistance = fiveDistance + 83;
        g.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
        goodsTypes = "货物类型: " + goodsTypes;
        if (goodsTypes.length() > 18) {
            goodsTypes = goodsTypes.substring(0, 18);
        }
        g.drawString(goodsTypes, left, sixDistance);

        //第七行 工作时间
        int sevenDistance = sixDistance + 95;
        int sevenFontSize = 26;
        g.setColor(new Color(46, 100, 233));
        g.setFont(new Font(fontStyle, Font.PLAIN, sevenFontSize));
        g.drawString("工作时间", (backWidth - g.getFontMetrics().stringWidth("工作时间")) / 2 - 10, sevenDistance);

        //第八行 工作时间，workTime，如果大于3个时间段，后面加...
        String workTime = "";
        int workNums = 3;
        if (workNums > workTimeArr.size()) {
            workNums = workTimeArr.size();
        }
        for (int i = 0; i < workNums; i++) {
            workTime = workTime + workTimeArr.get(i) + "  ";
        }
        if (workNums < workTimeArr.size()) {
            workTime = workTime + " ...";
        }
        int eightDistance = sevenDistance + 45;
        int eightSize = 25;
        g.setColor(new Color(202, 205, 251));
        g.setFont(new Font(fontStyle, Font.PLAIN, eightSize));
        g.drawString(workTime, (backWidth - g.getFontMetrics().stringWidth(workTime)) / 2, eightDistance);

        //第八行 二维码
        Image downImage = ImageIO.read(new URL(qrCodeImageUrl));
        System.out.println("二维码高：" + downImage.getHeight(null) + " 宽：" + downImage.getWidth(null));
        int nineDistance = eightDistance + 90;
        int qrCodeSize = 210;
        g.drawImage(downImage, (backWidth - downImage.getWidth(null)) / 2 + 111, nineDistance,
                qrCodeSize, qrCodeSize, null);

        // 释放此图形的上下文以及它使用的所有系统资源。
        g.dispose();

        //输入到文件中
        File outputfile = new File(System.getProperty("java.io.tmpdir") + "/lineDetailQRCode_" + System.currentTimeMillis() + ".jpg");
        ImageIO.write(image, "jpg", outputfile);

        //设置完成，输出//test 生产一定一定删掉
       // ImageIO.write(image, "JPEG", new FileOutputStream("/Users/hyman/Documents/otherProjects/test/realLine.jpg"));//保存图片 JPEG表示保存格式

        return outputfile;

    }

    /**
     * 对过长字符串进行折行处理
     *
     * @param g
     * @param backWidth
     * @param height
     * @param str
     * @return
     */
    private static int drawOneString(Graphics g, int backWidth, int height, String str) {
        int divOffset = 13;
        int heightAdd = 65;
        if (str.length() <= divOffset) {
            g.drawString(str, (backWidth - g.getFontMetrics().stringWidth(str)) / 2, height);
            return height;
        }
        String drawStr = str.substring(0, divOffset - 1);
        int left = (backWidth - g.getFontMetrics().stringWidth(drawStr)) / 2;
        g.drawString(drawStr, left, height);
        //最多显示两行,因为第一行有/符号，造成占位区域不同，所以如果大于规定的行数，那么减三个字
        int subInt = divOffset * 2 - 3;
        if (subInt > str.length()) {
            subInt = str.length();
        }
        drawStr = str.substring(divOffset - 1, subInt);
        g.drawString(drawStr, left, height += heightAdd);
        return height;
    }
}
