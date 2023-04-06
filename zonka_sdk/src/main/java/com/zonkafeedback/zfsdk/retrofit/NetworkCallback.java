package com.zonkafeedback.zfsdk.retrofit;


import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *This class explains the basic tasks involved in connecting to the network,
 * monitoring the network connection (including connection changes) * @param <T>
 */
public abstract class NetworkCallback<T> implements Callback<T> {


    private static final int NO_INTERNET = 9;

    public abstract void onSuccess(T t);

    public abstract void onFailure(FailureResponse failureResponse);

    public abstract void onError(Throwable t);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            FailureResponse failureErrorBody;
            failureErrorBody = getFailureErrorBody(call.request().url().url().getFile(), response);
            onFailure(failureErrorBody);
        }
    }


    @Override
    public void onFailure(Call<T> call, Throwable t) {
         if (t instanceof SocketTimeoutException || t instanceof UnknownHostException) {
            FailureResponse failureResponseForNoNetwork = getFailureResponseForNoNetwork();
            onFailure(failureResponseForNoNetwork);
        } else {
            onError(t);
        }
    }

    /**
     * This function handles all the failure operations.
     * @return
     */
    private FailureResponse getFailureResponseForNoNetwork() {
        FailureResponse failureResponse = new FailureResponse();
        failureResponse.setErrorMessage("You seem to be connected to a network, but there is no or low internet connectivity.");
        failureResponse.setErrorCode(NO_INTERNET);
        return failureResponse;
    }



    /**
     * Create your custom failure response out of server response
     * Also save Url for any further use
     */
    private FailureResponse getFailureErrorBody(String url, Response<T> errorBody) {
        FailureResponse failureResponse = new FailureResponse();
        failureResponse.setErrorCode(errorBody.code());
        if (errorBody.code() == 500) {
            failureResponse.setErrorMessage(errorBody.message());
        } else {
            try {
                failureResponse.setErrorMessage(errorBody.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return failureResponse;
    }
}
