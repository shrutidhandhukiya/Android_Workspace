import 'package:flutter/material.dart';

class HomeScreenProvider extends ChangeNotifier{
  var count=0;
  HomeScreenProvider(){
   apiCall();
  }
  void incre() {
    count++;
    notifyListeners();
  }
  void apiCall() {

  }
}