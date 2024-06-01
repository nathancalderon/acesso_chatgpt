import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatGPTEmoji {
  public String gerarEmoji(String OPENAI_API_KEY, String nomeDoFilme ) throws Exception{
    //montar o prompt
    //text block(Java 15+)
    String prompt = 
    """
      Apresente três emojis que defina esse filme %s.
    """.formatted(
      nomeDoFilme
    );
    var requisicao = new ChatGPTRequest(
      "text-davinci-003",
      prompt,
      100,
      1
    );

    var gson = new Gson();

    var requisicaoJSON = gson.toJson(requisicao);

    RequestBody requestBody = 
      RequestBody.create(
          requisicaoJSON, 
          MediaType.parse("application/json")
      );
    
    OkHttpClient httpClient = new OkHttpClient();

    Request request = 
      new Request.Builder()
      .url("https://api.openai.com/v1/completions")
      .addHeader("Media-Type", "application/json")
      .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
      .post(requestBody)
      .build();

      Response response = httpClient.newCall(request).execute();
      ChatGPTResponse chatGPTResponse =
        gson.fromJson(response.body().string(), ChatGPTResponse.class);
        String completion = 
          chatGPTResponse.getChoices().get(0).getText();
    return completion;
  }
}