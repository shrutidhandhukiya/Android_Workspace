// To parse this JSON data, do
//
//     final getCartModel = getCartModelFromJson(jsonString);

import 'dart:convert';

GetCartModel getCartModelFromJson(String str) => GetCartModel.fromJson(json.decode(str));

String getCartModelToJson(GetCartModel data) => json.encode(data.toJson());

class GetCartModel {
  int success;
  List<String> error;
  List<dynamic> data;

  GetCartModel({
    required this.success,
    required this.error,
    required this.data,
  });

  factory GetCartModel.fromJson(Map<String, dynamic> json) => GetCartModel(
    success: json["success"],
    error: List<String>.from(json["error"].map((x) => x)),
    data: List<dynamic>.from(json["data"].map((x) => x)),
  );

  Map<String, dynamic> toJson() => {
    "success": success,
    "error": List<dynamic>.from(error.map((x) => x)),
    "data": List<dynamic>.from(data.map((x) => x)),
  };
}
