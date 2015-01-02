package emperor.model.personnel;

/**
 *
 * @author RuN
 */
public class Names {
    
    // size = 50
    private static final String[] sureNames = { "王", "李", "张", "刘", "陈",
                                         "杨", "黄", "赵", "吴", "周", 
                                         "徐", "孙", "马", "朱", "胡", 
                                         "郭", "何", "高", "林", "罗", 
                                         "郑", "梁", "谢", "宋", "唐", 
                                         "许", "韩", "冯", "邓", "曹",
                                         "彭", "曾", "肖", "田", "董",
                                         "袁", "潘", "于", "蒋", "蔡",
                                         "余", "杜", "叶", "程", "苏",
                                         "魏", "吕", "丁", "任", "沈" };
    // size = 45
    private static final String[] basicGivenNames = { "一", "二", "三", "四", "五", "六", "七", "八", "九",
                                               "一保", "二保", "三保", "四保", "五保", "六保", "七保", "八保", "九保",
                                               "阿一", "阿二", "阿三", "阿四", "阿五", "阿六", "阿七", "阿八", "阿九",
                                               "小一", "小二", "小三", "小四", "小五", "小六", "小七", "小八", "小九",
                                               "重一", "重二", "重三", "重四", "重五", "重六", "重七", "重八", "重九" };
    
    private Names() {}
            
    public static String newRandomBasicName() {
    	
        int sureNameIndex = (int) (Math.random() * 49);
        int givenNameIndex = (int) (Math.random() * 44);
        
        return sureNames[sureNameIndex] + basicGivenNames[givenNameIndex];
    }
    
    public static String newRandomDecentName() {
    	
        int sureNameIndex = (int) (Math.random() * 49);
    	
    	return sureNames[sureNameIndex];
    }
    
    public static String newRandomHighClassName() {
    	
        int sureNameIndex = (int) (Math.random() * 49);
    	
    	return sureNames[sureNameIndex];
    }
    
    public static String newRandomLoyalName() {
    	
        int sureNameIndex = (int) (Math.random() * 49);
    	
    	return sureNames[sureNameIndex];
    }
}
