import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:flutter_easyloading/flutter_easyloading.dart';
import '../Config/config.dart';
import 'package:http/http.dart' as http;

class httpService {
  // String base_url = config().baseUrl;

  getAccessToken() async {
    var header = {
      "Content-Type": "application/json",
      "Authorization": "Basic " + base64.encode(utf8.encode(config().clientId + ":" + config().clientSecret))
    };
    http.Response? response =await  sendApiRequest(
        url: 'api/rest/categories', headers: header, body: {}, method: "post");
    // Notice how you have to call body from the response if you are using http to retrieve json
    final body = json.decode(response!.body);

    // This is how you get success value out of the actual json
    if (body['success']) {
      //Token is nested inside data field so it goes one deeper.
      final String token = body['data']['access_token'];
      return token;
    } else {
      return null;
    }
  }
  Future<http.Response?> sendApiRequest({required String url, required Map<String,String> headers,required dynamic body,BuildContext? context, required String method}) async {
    final uri = Uri.parse(config().baseUrl + url);

    if(context!=null){
      EasyLoading.show(status:'loading...');
      //show loader
    }
    http.Response? response;
    // print("Api url $uri");
    logger.i("===Request method $method with url $uri && body parameter ${body} header is $headers");
    // print("Api header $headers");
    switch (method) {
      case "get":
        response = await http.get(uri, headers: headers);
        print("Response of Api ${response.body}");
        break;
      case "post":
        response = await http.post(uri, headers: headers, body: body);
        print("Response of Api ${response.body}");
        break;
      case "put":
        response = await http.put(uri, headers: headers, body: body);
        print("Response of Api ${response.body}");
        break;
      case "delete":
        response = await http.delete(uri, headers: headers, body: body);
        print("Response of Api ${response.body}");
        break;
    }
    print("Response Code ${response!.statusCode}");
    if (response!.statusCode == 200) {
      if(context!=null){
        EasyLoading.dismiss();
        //hide loader
      }
      return response;
    }
    else if (response!.statusCode == 401) {
      String acessToken = getAccessToken();
      var newHeader = headers;
      newHeader["Authorization"] = "Bearer " + "b1e935e5bd3fdc34b5de35c3f8917373c9a68151";
      if(context!=null){
        EasyLoading.dismiss();
        //hide loader
      }
      return sendApiRequest(
          url: url, headers: newHeader, body: body, method: method,context: context);
    }
    else
    {
      if(context!=null){
        EasyLoading.dismiss();
        //hide loader
      }
      return null;
    }
  }
}
