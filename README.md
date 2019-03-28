## What is this repository for :question:
#### Simple Application with one to one connectivity using Firebase Real time Database written in MVC,MVP and MVVM architecture to better understand the android coding patterns. Purpose of writing same application functionality with 3 different pattern is to show how single application can be developed using 3 different patterns(Mvc, Mvp, Mvvm) :relieved:.

<br><br><br>

<p align="center"><img src="https://github.com/saksham24/Android-Firebase-Mvp-Mvc-Mvvm-chat/blob/master/Chatmvc - Java/chat.jpg" width="50%"><br>

<br><br><br>

## Mvc (Model View Controller)   :part_alternation_mark: :heavy_check_mark: C
Mvc is a clean approach in android putting views away from the controller. the controller is only responsible for updating models, once the model gets updated it can notify views and then the view can be updated using proper callbacks.
Traditional MVC is where there is a

**Model** : Acts as the model for data<br>
**View** : Deals with the view to the user which can be the UI<br>
**Controller** :Controls the interaction between Model and View, where view calls the controller to update the model. A view can call multiple controllers if needed..
<br> <br>

## Mvp (Model View Presenter)  :part_alternation_mark: :heavy_check_mark: :parking:
Some disadvantages of MVC can be overcome using Mvp approach. Presenter in Mvp contains all business logic and this class is far away from android Context or android related dependencies which provides flexibility to text business logic by simply using presenter class in test modules. Android related dependencies create complexity in testing. The presenter does not have any android dependency like Context, View etc and all the model updates and network requests are done via presenter. Once the model gets updated or a network request completes, the view is updated via presenter using callbacks to view from the presenter. No model and network request can directly approach views.
<br> <br>

## Mvvm (Model View View-Model)  :part_alternation_mark: :heavy_check_mark: :heavy_check_mark: :part_alternation_mark:
MVVM involves a data binding approach to make code short and reduce view handling code from java classes. View models are responsible to update view and once a view model is tied to a view then view get notified about their updating events. If a model gets updated by a user click then model send callbacks to view model which updates the view automatically as it gets tied to the views. Mvvm reduce code size but the implementation of MVVM is quite tough and it is difficult to debug big projects based on Mvvm.
<br><br>
<br><br>

<img src="https://github.com/saksham24/Android-Firebase-Mvp-Mvc-Mvvm-chat/blob/master/Chatmvc - Java/layer-1.png" width="150%"><br><br>
<br><br>
<img src="https://github.com/saksham24/Android-Firebase-Mvp-Mvc-Mvvm-chat/blob/master/Chatmvc - Java/compare.png" width="150%"><br><br>
## Choice of correct architect
:eyes:
<br>
Choice of a correct architect for a project involves the understanding of the modules which will be developed. Some functionalities work great on MVC, some with Mvp and some with Mvvm. It is quite difficult to debug project made using MVVM format so a small project is recommended for MVVM selection. MVP is still the best approach in writing android projects but MVP end up with 20% extra code with the same functionality written in MVC. Mvp is good if you are really interested in test cases and unit testing of modules. Mvc is a widely used technique in android. Google itself write it's repositories in MVC :thumbsup:.

<br><br><br> 
# END     :warning:
