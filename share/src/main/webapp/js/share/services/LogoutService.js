define(["dojo/_base/declare",
       "alfresco/services/LogoutService",
       "service/constants/Default"],
        function(declare, LogoutService, AlfConstants) {

   return declare([LogoutService], {

      doLogout: function alfresco_services_LogoutService__doLogout() {
         this.serviceXhr({
            url: AlfConstants.URL_PAGECONTEXT + "dologout",
            method: "POST",
            data: {
                redirectURL: this.casLogout,
                redirectURLQueryKey: this.paramName,
                redirectURLQueryValue: this.logoutDestination 
            },
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            successCallback: this.reloadPage,
            callbackScope: this
         });

      }
   });
});
