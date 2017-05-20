package com.prj1.stand.artworldviewer.utilities;

import com.prj1.stand.artworldviewer.constants.Constants;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;
import com.prj1.stand.artworldviewer.services.fetching.RetrofitClient;

/**
 * Utility that handle passing the base_url to our
 * application through a static method
 *
 * Created by Stand on 5/6/2017.
 */

public class ApiUtility {
    public static ApiFetchingService getApiService() {
        return RetrofitClient.getClient(Constants.artRoot).create(ApiFetchingService.class);
    }
}
