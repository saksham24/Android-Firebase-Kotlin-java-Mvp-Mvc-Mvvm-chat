# Android-Firebase-Mvp-Mvc-Mvvm-chat
Simple chat Application with one to one connectivity using Firebase Real time Database written in MVC,MVP and MVVM  architecture to better understand the android coding patterns. Purpose of writing same application functionality with 3 different pattern is to show how single application can be developed using 3 different patterns(Mvc, Mvp, Mvvm).


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Readme</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <style type="text/css">
  	.line-height{
     line-height: 25px;
  	}
  	.margin{margin-top: 25px;}
  </style>
</head>
<body>

<div class="jumbotron text-center">
  <h1>Here comes GIF</h1>
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <div class="text-center"><img src="https://raw.githubusercontent.com/saksham24/Android-Firebase-Mvp-Mvc-Mvvm-chat/master/Chatmvc/app/src/main/res/drawable/app_icon.png" width="50%"></div>
      <div class="col-sm-12 margin">MODEL VIEW CONTROLLER contains acitivity as controller, xml or java classes extending View  as view and database classes as model.</div>
    </div>
    <div class="col-sm-4">
      <div class="text-center"><img src="https://raw.githubusercontent.com/saksham24/Android-Firebase-Mvp-Mvc-Mvvm-chat/master/Chatmvp/app/src/main/res/drawable/app_icon.png" width="50%"></div>
      <div class="col-sm-12 margin">MODEL VIEW PRESENTER contains activity,fragments,xmls,java classes extending views as View, presenter class  containing all bussiness logics, and databse classses as models</div>
    </div>
    <div class="col-sm-4">
     <div class="text-center"><img src="https://raw.githubusercontent.com/saksham24/Android-Firebase-Mvp-Mvc-Mvvm-chat/master/Chatmvvm/app/src/main/res/drawable/app_icon.png" width="50%"></div>
      <div class="col-sm-12 margin">View and Model are same as in MVP AND MVC view updations are done using data binding by making view Models. View model is is bind to view and handles all Ui updates
      </div>
    </div> 
  </div>
  <div class="row margin"><div class="col-sm-2"><h2>M<sub>VC</sub></h2></div><div class="col-sm-10 line-height">Mvc is clean approach in android putting views away from controller. controller is only reponsible for updating models, once model get updated it can notify views and then view can be updated using proper callbacks.<br><br>
Traditional MVC is where there is a

Model: Acts as the model for data<br>
View : Deals with the view to the user which can be the UI<br>
Controller: Controls the interaction between Model and View, where view calls the controller to update model. View can call multiple controllers if needed.</div></div>
  <div class="row margin"><div class="col-sm-2"><h2>M<sub>VP</sub></h2></div><div class="col-sm-10 line-height">Some disadvantages of Mvc can be overcomed using Mvp approach. Presenter in Mvp contains all bussiness logics and this class is far away from android Context or android related dependencies which provides flexibility to text bussiness logic by simply using presenter class in test modules.Android related dependencies create complexity in testing. Presenter do not have and android dependency like Context,View etc and all the model updation and network request are done via presenter. Once the model get updated or a network request completes view are updated via presenter using callbacks to view from presenter. No model and network request can directly approach views.</div></div>
  <div class="row margin"><div class="col-sm-2"><h2>M<sub>VVM</sub></h2></div><div class="col-sm-10 line-height">Mvvm involves data bindind approach to make code short and reduce view handling code from java classes. View models are responsible to update view and once a view model is tied to a view then view get notified about their updating events. If a model get updated by a user click then model send callbacks to view model which updates the view automatically as it get tied to the views. Mvvm reduce code size but implementation of mvvm is quite tough and it is difficult to debug big projects based on Mvvm.</div></div>
  <div class="row margin"><div class="col-sm-12 text-center"><img src="https://raw.githubusercontent.com/saksham24/Android-Firebase-Mvp-Mvc-Mvvm-chat/master/Chatmvc/app/src/main/res/drawable/app_icon.png"></div><div class="col-sm-10 col-sm-offset-2 line-height margin">Lorem ipsum dolor sit amet, consectetur adipisicing elit.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris..Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris..Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris..Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris..Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris..Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris..Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</div>
  </div>
  
</div>

</body>
</html>
