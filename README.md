# redux-oidc-resource

This is the sample spring boot RESTful service using OAuth2 protocol that is used as part of the demo together with the redux-oidc-client project.

After starting of redux-oidc-client and redux-oidc-resource projects and further logging in, the app will query the RESTful services of the redux-oidc-resource secured by OAuth2.

Before running make sure that resource/application.yml file includes proper userInfoUri parameter. For Google it is https://www.googleapis.com/userinfo/v2/me .


### Running locally
Clone this repo and run as spring boot application.
