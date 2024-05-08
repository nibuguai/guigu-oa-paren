
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王骞
 * @Date 2023/6/25 14:48
 * @Version 1.0
 */
@Slf4j
public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + "\\service-oa";
        log.info(projectPath);
        String outputDir = projectPath + "/src/main/java";
        gc.setOutputDir(outputDir);// 设置代码生成路径
        gc.setFileOverride(false);// 是否覆盖以前文件
        gc.setOpen(false);// 是否打开生成目录
        gc.setAuthor("王骞");// 设置项目作者名称
        gc.setIdType(IdType.ID_WORKER);// 设置主键策略
        gc.setBaseResultMap(true);// 生成基本ResultMap
        gc.setBaseColumnList(true);// 生成基本ColumnList
        // gc.setServiceName("%sService");//去掉服务默认前缀
        gc.setDateType(DateType.ONLY_DATE);// 设置时间类型
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.111.3:3306/learning?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.wq");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        mpg.setPackageInfo(pc);
        // 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);// 自动lombok
        sc.setRestControllerStyle(true);
        sc.setControllerMappingHyphenStyle(false);
        sc.setLogicDeleteFieldName("deleted");// 设置逻辑删除
        // 设置自动填充配置
        TableFill gmt_create = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmt_modified = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmt_create);
        tableFills.add(gmt_modified);
        sc.setTableFillList(tableFills);
        // 乐观锁
        sc.setVersionFieldName("version");
        sc.setRestControllerStyle(true);// 驼峰命名
        // 设置xml文件生成路径
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // 这里可以添加自定义的参数
            }
        };
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        fileOutConfigList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);
        mpg.setCfg(injectionConfig);

        //  sc.setTablePrefix("tbl_"); 设置表名前缀
        // sc.setInclude(scanner("表名，多个英文逗号分割").split(","));
        sc.setInclude("sys_role_menu");
        mpg.setStrategy(sc);

        // 生成代码
        mpg.setTemplate(new TemplateConfig().setXml(null));
        mpg.execute();
    }
}
