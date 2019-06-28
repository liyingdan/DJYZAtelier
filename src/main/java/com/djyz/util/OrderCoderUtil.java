package com.djyz.util;

import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
    /**
     * @Desc:   * 订单编码码生成器，生成32位数字编码，
     * @生成规则 1位单号类型+17位时间戳+14位(用户id加密&随机数)
     */
    @Configuration
    public class OrderCoderUtil {

        /** 摄影套餐订单类别头 */
        private static final String ORDER_CODE = "PH";
        /** 服装订单类别头 */
        private static final String RETURN_ORDER = "CL";
        /** 随即编码 */
        private static final int[] r = new int[]{7, 9, 6, 2, 8 , 1, 3, 0};
        /** 用户id和随机数总长度 */
        private static final int maxLength = 8;

        /**
         * 摄影套餐订单类别头
         * @param userId
         */
        public  String getComboOrderCode(Long userId){
            return ORDER_CODE + getCode(userId);
        }

        /**
         * 服装订单类别头
         * @param userId
         */
        public String getRentClothesCode(Long userId){
            return RETURN_ORDER + getCode(userId);
        }


        /**
         * 更具id进行加密+加随机数组成固定长度编码
         */
        private static String toCode(Long id) {
            String idStr = id.toString();
            StringBuilder idsbs = new StringBuilder();
            for (int i = idStr.length() - 1 ; i >= 0; i--) {
                idsbs.append(r[idStr.charAt(i)-'0']);
            }
            return idsbs.append(getRandom(maxLength - idStr.length())).toString();
        }

        /**
         * 生成时间戳
         */
        private static String getDateTime(){
            DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            return sdf.format(new Date());
        }

        /**
         * 生成固定长度随机码
         * @param n    长度
         */
        private static long getRandom(long n) {
            long min = 1,max = 9;
            for (int i = 1; i < n; i++) {
                min *= 10;
                max *= 10;
            }
            long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min ;
            return rangeLong;
        }

        /**
         * 生成不带类别标头的编码
         * @param userId
         */
        private static synchronized String getCode(Long userId){
            userId = userId == null ? 10000 : userId;
            return getDateTime() + toCode(userId);
        }


    }


