import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.*;

public class NLUPractice {
    public static void main(String[] args) {
        NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
                NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
                "5c8c14fc-fb0e-4270-a056-15a96292e213",
                "ZWrfSab0O57t"
        );

        String text = "我热爱墨尔本，墨尔本是一个很美丽的城市";

        EntitiesOptions entities = new EntitiesOptions.Builder().emotion(true).sentiment(true).limit(2).build();

        KeywordsOptions keywordsOptions = new KeywordsOptions.Builder()
                .emotion(true)
                .sentiment(true)
                .limit(2)
                .build();

        Features features = new Features.Builder().entities(entities).keywords(keywordsOptions).build();

        AnalyzeOptions parameters = new AnalyzeOptions.Builder().text(text).features(features).build();

        AnalysisResults results = service.analyze(parameters).execute();

        System.out.println(results);
    }
}
