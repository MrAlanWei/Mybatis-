import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Genreator {
    public static void generator() throws Exception{
           List<String> warnings = new ArrayList<String>();
           boolean overwrite = true;
           //��Ŀ��·��configFile��Ҫ������,�ҵ�������,����ʹ�þ���·��
           File configFile = new File(Genreator.class.getResource("/genreatorConfig.xml").getFile());
           ConfigurationParser cp = new ConfigurationParser(warnings);
           Configuration config = cp.parseConfiguration(configFile);
           DefaultShellCallback callback = new DefaultShellCallback(overwrite);
           MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
           myBatisGenerator.generate(null);
    }
    public static void main(String[] args) {
        try {
            generator();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}