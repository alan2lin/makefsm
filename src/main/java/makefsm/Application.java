package makefsm;

import makefsm.util.UTF8Control;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.util.Locale;
import java.util.ResourceBundle;

@SpringBootApplication
@ImportResource("classpath:spring-root.xml")
public class Application implements CommandLineRunner {

	private final static Logger log =
			LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(Application.class);

        app.run(args);

        return;
	}


	@Override
	public void run(String... args) throws Exception {

		Run.main(args);

		return ;
	}






	/**
	 * 生成命令行的选项， 具体的选项描述在资源文件 message.properties中，
	 * 支持i18n资源国际化,目前只有中英文两个版本 message_zh_CN.properties， 需要的请自行翻译并增加 properties文件 .
	 * @param msg
	 * @return 该命令行的所有选项集合
	 */
	private static Options options(ResourceBundle msg) {

		Options options = new Options();

		Option o = new Option("b", "branch", true, msg.getString("BRANCH"));
		o.setType(int.class);
		options.addOption(o);

		Option oc = new Option("c", "regioncode", true, msg.getString("REGIONCODE") );
		oc.setType(int.class);
		options.addOption(oc);

		options.addOption("h", "help", false, msg.getString("HELP") );
		options.addOption("w", "workerid", true, msg.getString("WORKERID") );
		options.addOption("m", "memberid", true, msg.getString("MEMBERID") );

		Option ot = new Option("t", "threads", true, msg.getString("THREADS") );
		ot.setType(int.class);
		options.addOption(ot);


		options.addOption("locale", "locale", true, msg.getString("LOCALE") );

		return options;
	}

	/**
	 *  检查选项是否是数字
	 * @param cl
	 * @param optionName
	 * @param msg
	 * @param ErrorMsgCode
	 * @return
	 */
	private static boolean checkOption(CommandLine cl, String optionName, ResourceBundle msg, String ErrorMsgCode){
		boolean bRet = true;
		if (cl.hasOption(optionName)){

			if ( !StringUtils.isNumeric(cl.getOptionValue(optionName)) ){
				log.error(msg.getString(ErrorMsgCode));
				bRet = false;
			}
		}else{
			bRet = false;
		}
		return bRet;
	}

	/**
	 * 获取语言区域，以便本地化，假如系统无改语言设定，则用默认的语言设定
	 * @param language 语言设定
	 * @return
	 */
	private static Locale getLocale(String language){
		Locale locale = null;
		try{
			if (language!=null && !language.isEmpty()){
				String[] lang = language.split("_");
				if(lang.length==1){
					locale = new Locale(lang[0]);
				}else{
					locale = new Locale(lang[0],lang[1]);
				}

			}else{
				locale = Locale.getDefault();
			}

		}catch(Exception e){
			locale = Locale.getDefault();
		}
		return locale;
	}

	static private void traceLocaleInfo(Locale locale){

		log.trace("语言代码: " + locale.getLanguage());
		log.trace("地区代码: " + locale.getCountry());
		log.trace("语言地区代码: " + locale.toString());
		log.trace("---------------------------------------");
		log.trace("语言描述: " + locale.getDisplayLanguage());
		log.trace("地区描述: " + locale.getDisplayCountry());
		log.trace("语言,地区描述: " + locale.getDisplayName());
		//log.trace("---------------------------------------");
		//log.trace("在美国默认语言叫: " + locale.getDisplayLanguage(Locale.US));
		//log.trace("在美国默认地区叫: " + locale.getDisplayCountry(Locale.US));
		//log.trace("在美国默认语言,地区叫: " + locale.getDisplayName(Locale.US));
		//log.trace("在日本默认语言代码叫: " + locale.getDisplayLanguage(Locale.JAPAN));
		//log.trace("在日本默认地区代码叫: " + locale.getDisplayCountry(Locale.JAPAN));
		//log.trace("在日本默认语言,地区代码叫: " + locale.getDisplayName(Locale.JAPAN));
		log.trace("---------------------------------------");
		log.trace("语言环境三字母缩写: " + locale.getISO3Language());
		log.trace("国家环境三字母缩写: " + locale.getISO3Country());
		log.trace("---------------------------------------");
		// 机器已经安装的语言环境数组
		Locale[] allLocale = Locale.getAvailableLocales();

		// 返回 ISO 3166 中所定义的所有两字母国家代码
		String[] str1 = Locale.getISOCountries();
		// 返回 ISO 639 中所定义的所有两字母语言代码
		String[] str2 = Locale.getISOLanguages();

	}
	private static ResourceBundle getMessagesByLang(String lang){
		Locale locale_default = getLocale(lang);
		traceLocaleInfo(locale_default);

		ResourceBundle msg = ResourceBundle.getBundle("messages", locale_default,new UTF8Control() );

		return msg;
	}
}
