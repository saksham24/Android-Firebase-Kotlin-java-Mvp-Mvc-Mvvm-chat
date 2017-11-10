## What is this repository for :question:
#### Simple Application with one to one connectivity using Firebase Real time Database written in MVC,MVP and MVVM architecture to better understand the android coding patterns. Purpose of writing same application functionality with 3 different pattern is to show how single application can be developed using 3 different patterns(Mvc, Mvp, Mvvm) :relieved:.

<br><br><br>

<p align="center"><img src="https://github.com/saksham24/Android-Firebase-Mvp-Mvc-Mvvm-chat/blob/master/Chatmvc/chat.jpg" width="50%"><br>

<br><br><br>

## Mvc (Model View Controller)   :part_alternation_mark: :heavy_check_mark: C
Mvc is clean approach in android putting views away from controller. controller is only reponsible for updating models, once model get updated it can notify views and then view can be updated using proper callbacks.<br>
Traditional MVC is where there is a

**Model** : Acts as the model for data<br>
**View** : Deals with the view to the user which can be the UI<br>
**Controller** : Controls the interaction between Model and View, where view calls the controller to update model. View can call multiple controllers if needed.
<br> <br>

## Mvp (Model View Presenter)  :part_alternation_mark: :heavy_check_mark: :parking:
Some disadvantages of Mvc can be overcomed using Mvp approach. Presenter in Mvp contains all bussiness logics and this class is far away from android Context or android related dependencies which provides flexibility to text bussiness logic by simply using presenter class in test modules.Android related dependencies create complexity in testing. Presenter do not have any android dependency like Context,View etc and all the model updation and network request are done via presenter. Once the model get updated or a network request completes, view are updated via presenter using callbacks to view from presenter. No model and network request can directly approach views.
<br> <br>

## Mvvm (Model View View-Model)  :part_alternation_mark: :heavy_check_mark: :heavy_check_mark: :part_alternation_mark:
Mvvm involves data bindind approach to make code short and reduce view handling code from java classes. View models are responsible to update view and once a view model is tied to a view then view get notified about their updating events. If a model get updated by a user click then model send callbacks to view model which updates the view automatically as it get tied to the views. Mvvm reduce code size but implementation of mvvm is quite tough and it is difficult to debug big projects based on Mvvm.
<br><br>
<br><br>

<img src="https://github.com/saksham24/Android-Firebase-Mvp-Mvc-Mvvm-chat/blob/master/Chatmvc/layer-1.png" width="150%"><br><br>
<br><br>
<img src="https://github.com/saksham24/Android-Firebase-Mvp-Mvc-Mvvm-chat/blob/master/Chatmvc/compare.png" width="150%"><br><br>
## Choice of correct architect
:eyes:
<br>
Choice of correct architect for a project involve understanding of the modules which will be developed. Some functionalities work great on Mvc, some with Mvp and some with Mvvm. It is quite difficult to debug project made using mvvm format so small project are recomemded for mvvm selection. Mvp is still the best approach in writting android projects but mvp end up with 20% extra code with same functionality written in Mvc. Mvp is good if you are realy interested in test cases and unit testing of modules. Mvc is widely used technique in andorid and google itself write its repositories in Mvc :thumbsup:.

<br><br><br> 
# END     :warning:
