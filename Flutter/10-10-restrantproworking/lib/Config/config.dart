import 'package:flutter/cupertino.dart';
import 'package:logger/logger.dart';

class config{
  String baseUrl="http://restaurant.animize.net/";
  String clientId="";
  String clientSecret="";
}
var logger = Logger();
GlobalKey<NavigatorState> navigationKey=GlobalKey<NavigatorState>();
