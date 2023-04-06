package com.zonkafeedback.zfsdk.retrofit;



import com.zonkafeedback.zfsdk.model.contactResponse.ContactResponse;
import com.zonkafeedback.zfsdk.model.eventModel.EventRequest;
import com.zonkafeedback.zfsdk.model.sessionRequestModel.UpdateSessionRequest;
import com.zonkafeedback.zfsdk.model.sessionResponseModel.SessionResponse;
import com.zonkafeedback.zfsdk.model.widgetResponse.Widget;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Interface used to set the API end point urls.
 */
public interface ApiInterface {



    @GET("distribution/validateCode/returnResponse/{token}")
    Call<Widget> hitSurveyActiveApi(@Path("token") String token);


    @POST("contacts/tracking")
    Call<ContactResponse> hitCreateContactApi(@Body HashMap<String, String> hashMap);


    @POST("contacts/sessionsUpdate/{token}")
    Call<SessionResponse> hitSessionUpdateAPi(@Path("token") String token, @Body UpdateSessionRequest sessionRequest);



    @POST("surveys/logInteraction")
    Call<ResponseBody> sendEventToServer(@Body EventRequest request);


}
