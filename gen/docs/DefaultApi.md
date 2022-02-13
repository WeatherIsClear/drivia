# DefaultApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**joinDriverDrivingDetails**](DefaultApi.md#joinDriverDrivingDetails) | **GET** /driver/driving/{driverId}/{drivingId} | 


<a name="joinDriverDrivingDetails"></a>
# **joinDriverDrivingDetails**
> InlineResponse200 joinDriverDrivingDetails(driverId, drivingId)



joinDriver-driving-details-information

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Long driverId = 5L; // Long | driver_id
    Long drivingId = 3L; // Long | driving-id
    try {
      InlineResponse200 result = apiInstance.joinDriverDrivingDetails(driverId, drivingId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#joinDriverDrivingDetails");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **driverId** | **Long**| driver_id |
 **drivingId** | **Long**| driving-id |

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

