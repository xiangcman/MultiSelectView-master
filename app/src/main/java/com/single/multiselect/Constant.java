package com.single.multiselect;

import com.library.multiselct.SelectBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangcheng on 17/10/30.
 */

public class Constant {
    private static final String[] province = new String[]{"上海", "云南", "内蒙古", "北京", "吉林", "四川"};

    private static final String[] city1 = new String[]{"嘉定区", "奉贤区", "宝山区", "崇明县", "徐汇区", "普陀区"};
    private static final String[] city2 = new String[]{"临沧市", "丽江市", "保山市", "大理州", "德宏州", "怒江州"};
    private static final String[] city3 = new String[]{"乌兰察布", "乌海市", "兴安盟", "包头市", "呼伦贝尔", "呼和浩特"};
    private static final String[] city4 = new String[]{"东城区", "丰台区", "大兴区", "宣武区", "密云区", "崇文区"};
    private static final String[] city5 = new String[]{"吉林市", "四平市", "延边州", "松原市", "白城市", "白山市"};
    private static final String[] city6 = new String[]{"乐山市", "内江市", "凉山州", "南充市", "宜宾市", "巴中市"};

    private static final String[] district11 = new String[]{"华亭镇", "南翔镇", "嘉定工业", "城区", "外冈镇", "安亭镇"};
    private static final String[] district12 = new String[]{"南桥镇", "四团镇", "奉城镇", "庄行镇", "石林镇", "海湾镇"};
    private static final String[] district13 = new String[]{"城区", "大场镇", "宝山城市", "庙行镇", "月浦镇", "杨行镇"};
    private static final String[] district14 = new String[]{"三星镇", "东平镇", "中兴镇", "向化镇", "城桥镇", "堡镇"};
    private static final String[] district15 = new String[]{"城区"};
    private static final String[] district16 = new String[]{"城区"};

    private static final String[] district21 = new String[]{"临翔区", "云县", "凤庆县", "双江县", "永德县", "沧源县"};
    private static final String[] district22 = new String[]{"华坪县", "古城区", "永胜县", "玉龙县"};
    private static final String[] district23 = new String[]{"施甸县", "昌宁县", "腾冲县", "隆阳县", "龙陵县"};
    private static final String[] district24 = new String[]{"云龙县", "剑川县", "南涧县", "大理市", "宾川县", "巍山县"};
    private static final String[] district25 = new String[]{"梁河县", "瑞丽市", "盈江县", "芒市", "陇川县"};
    private static final String[] district26 = new String[]{"兰坪县", "泸水县", "福贡县", "贡山县",};

    private static final String[] district31 = new String[]{"丰镇市", "兴和县", "凉城县", "化德县", "卓资县", "商都县"};
    private static final String[] district32 = new String[]{"乌达区", "海勃湾区", "海南区"};
    private static final String[] district33 = new String[]{"乌兰浩特", "突泉县", "阿尔山市"};
    private static final String[] district34 = new String[]{"东河区", "九原区", "固阳县", "土默特右", "昆都仑区", "白云矿区"};
    private static final String[] district35 = new String[]{"扎兰顿市", "新巴尔虎", "根河市", "海拉尔区", "满洲里市", "牙克石市"};
    private static final String[] district36 = new String[]{"和林格尔", "回民区", "土默特左", "托克托县", "新城区", "武川县"};

    private static final String[] district41 = new String[]{"内环到三环"};
    private static final String[] district42 = new String[]{"三环到四环", "二环到三环", "五环到六环", "六环之外", "四环到五环"};
    private static final String[] district43 = new String[]{"五环到六环", "亦庄经济", "六环之外", "四环到五环"};
    private static final String[] district44 = new String[]{"内环到三环"};
    private static final String[] district45 = new String[]{"城区", "城区以外"};
    private static final String[] district46 = new String[]{"三环到四环", "二环到三环", "五环到六环", "六环之外", "四环到五环"};

    private static final String[] district51 = new String[]{"丰满区", "昌邑区", "桦甸市", "永吉县", "磐石市", "舒兰市"};
    private static final String[] district52 = new String[]{"伊通县", "公主岭市", "双辽市", "梨树县", "铁东区", "铁西区"};
    private static final String[] district53 = new String[]{"和龙市", "图们市", "安图市", "延吉市", "敦化市", "汪清市"};
    private static final String[] district54 = new String[]{"乾安县", "前郭县", "宁江区", "扶余县", "长岭县"};
    private static final String[] district55 = new String[]{"大安市", "兆北区", "通榆县"};
    private static final String[] district56 = new String[]{"临江市", "抚松县", "江源区", "长白县", "靖宇县"};

    private static final String[] district61 = new String[]{"五通桥区", "井研县", "夹江县", "峨眉山市", "峨边县", "市中区"};
    private static final String[] district62 = new String[]{"东兴区", "威远县", "市中区", "资中县", "隆昌县"};
    private static final String[] district63 = new String[]{"会东县", "会理县", "冕宁县", "喜德县", "宁南县", "布拖县"};
    private static final String[] district64 = new String[]{"仪陇县", "南部县", "嘉陵区", "营山县", "蓬安县", "西充县"};
    private static final String[] district65 = new String[]{"兴文县", "南溪区", "宜宾县", "屏山县", "江安县", "珙县"};
    private static final String[] district66 = new String[]{"南江县", "巴州区", "平昌县", "通江县"};

    public static List<PcdSelectBean> initData() {
        List<PcdSelectBean> pcdSelectBeanList = new ArrayList<>();
        for (int i = 0; i < province.length; i++) {
            PcdSelectBean pcdSelectBean = new PcdSelectBean(province[i]);
            if (i == 0) {
                for (int j = 0; j < city1.length; j++) {
                    PcdSelectBean citySelectBean = new PcdSelectBean(city1[j]);
                    if (j == 0) {
                        for (int m = 0; m < district11.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district11[m]));
                        }
                    } else if (j == 1) {
                        for (int m = 0; m < district12.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district12[m]));
                        }
                    } else if (j == 2) {
                        for (int m = 0; m < district13.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district13[m]));
                        }
                    } else if (j == 3) {
                        for (int m = 0; m < district14.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district14[m]));
                        }
                    } else if (j == 4) {
                        for (int m = 0; m < district15.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district15[m]));
                        }
                    } else if (j == 5) {
                        for (int m = 0; m < district16.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district16[m]));
                        }
                    }
                    pcdSelectBean.initializeChild(citySelectBean);
                }

            } else if (i == 1) {
                for (int j = 0; j < city2.length; j++) {
                    PcdSelectBean citySelectBean = new PcdSelectBean(city2[j]);

                    if (j == 0) {
                        for (int m = 0; m < district21.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district21[m]));
                        }
                    } else if (j == 1) {
                        for (int m = 0; m < district22.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district22[m]));
                        }
                    } else if (j == 2) {
                        for (int m = 0; m < district23.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district23[m]));
                        }
                    } else if (j == 3) {
                        for (int m = 0; m < district24.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district24[m]));
                        }
                    } else if (j == 4) {
                        for (int m = 0; m < district25.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district25[m]));
                        }
                    } else if (j == 5) {
                        for (int m = 0; m < district26.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district26[m]));
                        }
                    }
                    pcdSelectBean.initializeChild(citySelectBean);
                }
            } else if (i == 2) {
                for (int j = 0; j < city3.length; j++) {
                    PcdSelectBean citySelectBean = new PcdSelectBean(city3[j]);
                    if (j == 0) {
                        for (int m = 0; m < district31.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district31[m]));
                        }
                    } else if (j == 1) {
                        for (int m = 0; m < district32.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district32[m]));
                        }
                    } else if (j == 2) {
                        for (int m = 0; m < district33.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district33[m]));
                        }
                    } else if (j == 3) {
                        for (int m = 0; m < district34.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district34[m]));
                        }
                    } else if (j == 4) {
                        for (int m = 0; m < district35.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district35[m]));
                        }
                    } else if (j == 5) {
                        for (int m = 0; m < district36.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district36[m]));
                        }
                    }
                    pcdSelectBean.initializeChild(citySelectBean);
                }
            } else if (i == 3) {
                for (int j = 0; j < city4.length; j++) {
                    PcdSelectBean citySelectBean = new PcdSelectBean(city4[j]);

                    if (j == 0) {
                        for (int m = 0; m < district41.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district41[m]));
                        }
                    } else if (j == 1) {
                        for (int m = 0; m < district42.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district42[m]));
                        }
                    } else if (j == 2) {
                        for (int m = 0; m < district43.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district43[m]));
                        }
                    } else if (j == 3) {
                        for (int m = 0; m < district44.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district44[m]));
                        }
                    } else if (j == 4) {
                        for (int m = 0; m < district45.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district45[m]));
                        }
                    } else if (j == 5) {
                        for (int m = 0; m < district46.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district46[m]));
                        }
                    }
                    pcdSelectBean.initializeChild(citySelectBean);
                }
            } else if (i == 4) {
                for (int j = 0; j < city5.length; j++) {
                    PcdSelectBean citySelectBean = new PcdSelectBean(city5[j]);

                    if (j == 0) {
                        for (int m = 0; m < district51.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district51[m]));
                        }
                    } else if (j == 1) {
                        for (int m = 0; m < district52.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district52[m]));
                        }
                    } else if (j == 2) {
                        for (int m = 0; m < district53.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district53[m]));
                        }
                    } else if (j == 3) {
                        for (int m = 0; m < district54.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district54[m]));
                        }
                    } else if (j == 4) {
                        for (int m = 0; m < district55.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district55[m]));
                        }
                    } else if (j == 5) {
                        for (int m = 0; m < district56.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district56[m]));
                        }
                    }
                    pcdSelectBean.initializeChild(citySelectBean);
                }
            } else if (i == 5) {
                for (int j = 0; j < city6.length; j++) {
                    PcdSelectBean citySelectBean = new PcdSelectBean(city6[j]);

                    if (j == 0) {
                        for (int m = 0; m < district61.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district61[m]));
                        }
                    } else if (j == 1) {
                        for (int m = 0; m < district62.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district62[m]));
                        }
                    } else if (j == 2) {
                        for (int m = 0; m < district63.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district63[m]));
                        }
                    } else if (j == 3) {
                        for (int m = 0; m < district64.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district64[m]));
                        }
                    } else if (j == 4) {
                        for (int m = 0; m < district65.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district65[m]));
                        }
                    } else if (j == 5) {
                        for (int m = 0; m < district66.length; m++) {
                            citySelectBean.initializeChild(new PcdSelectBean(district66[m]));
                        }
                    }
                    pcdSelectBean.initializeChild(citySelectBean);
                }
            }
            pcdSelectBeanList.add(pcdSelectBean);
        }
        return pcdSelectBeanList;
    }

    static class PcdSelectBean extends SelectBean {

        public PcdSelectBean(String name) {
            super(name);
        }
    }
}
