package com.zonkafeedback.zfsdk.retrofit;

import android.text.TextUtils;
import android.util.Log;

import com.zonkafeedback.zfsdk.Constant;
import com.zonkafeedback.zfsdk.model.contactResponse.ContactResponse;
import com.zonkafeedback.zfsdk.model.eventModel.EventRequest;
import com.zonkafeedback.zfsdk.model.sessionRequestModel.UpdateSessionRequest;
import com.zonkafeedback.zfsdk.model.sessionResponseModel.SessionResponse;
import com.zonkafeedback.zfsdk.model.widgetResponse.Widget;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * ApiManager class creates the retrofit instance and link the API'S to the respective end points.
 */
public class ApiManager {

    private static final ApiManager instance = new ApiManager();

    private final ApiInterface apiServerHostClient;
    private final ApiInterface contactTrackingHostClient;

    private ApiManager() {

        OkHttpClient.Builder httpApiServerClient = getHttpClient();
        assert httpApiServerClient != null;
        apiServerHostClient = getRetrofitServiceForServerHost(httpApiServerClient);
        contactTrackingHostClient = getRetrofitServiceForServerHostContactTracking(httpApiServerClient);

    }

    private ApiInterface getRetrofitServiceForServerHostContactTracking(OkHttpClient.Builder httpApiServerClient) {
        String baseUrl = "";
        String zfRegion = DataManager.getInstance().getRegion();
        if (!TextUtils.isEmpty(zfRegion) && zfRegion.equalsIgnoreCase("EU")) {
            baseUrl = "https://e.apis.zonkafeedback.com/";
        } else {
            baseUrl = "https://us1.apis.zonkafeedback.com/";

        }
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.client(httpApiServerClient.build()).build();
        return retrofit.create(ApiInterface.class);
    }

    public static ApiManager getInstance() {
        return instance;
    }

    /**
     * Creates the server host connection.
     *
     * @param httpClient
     * @return
     */
    private ApiInterface getRetrofitServiceForServerHost(OkHttpClient.Builder httpClient) {
        String baseUrl = "";
        String zfRegion = DataManager.getInstance().getRegion();
        if (!TextUtils.isEmpty(zfRegion) && zfRegion.equalsIgnoreCase("EU")) {
            baseUrl = Constant.HTTPS + "e" + Constant.RETROFIT_URL;
        } else {
            baseUrl = Constant.HTTPS + "us1" + Constant.RETROFIT_URL;
        }


        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.client(httpClient.build()).build();
        return retrofit.create(ApiInterface.class);
    }


    /**
     * Method to create {@link OkHttpClient} builder by adding required headers in the {@link Request}
     *
     * @return OkHttpClient object
     */
    private OkHttpClient.Builder getHttpClient() {
        try {
            return new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        Request original = chain.request();
                        Request.Builder requestBuilder;
                        requestBuilder = original.newBuilder()
                                .method(original.method(), original.body());
                        Request request = requestBuilder.build();
                        Response response = chain.proceed(request);
                        Log.e("Response =", response.message());
                        return response;
                    })
                    .readTimeout(20000, TimeUnit.MILLISECONDS)
                    .writeTimeout(20000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public Call<Widget> hitSurveyActiveApi(String token) {
        return apiServerHostClient.hitSurveyActiveApi(token);
    }

    public Call<ContactResponse> hitCreateContactApi(HashMap<String, String> hashMap) {
        return contactTrackingHostClient.hitCreateContactApi(hashMap);
    }

    public Call<ResponseBody> sendEventToServer(EventRequest request) {
        return apiServerHostClient.sendEventToServer(request);
    }

    public Call<SessionResponse> updateSessionToServer(String token, UpdateSessionRequest sessionRequest) {
        return apiServerHostClient.hitSessionUpdateAPi(token, sessionRequest);
    }

}