// To parse this JSON data, do
//
//     final bookModel = bookModelFromJson(jsonString);

import 'dart:convert';

BookModel bookModelFromJson(String str) => BookModel.fromJson(json.decode(str));

String bookModelToJson(BookModel data) => json.encode(data.toJson());

class BookModel {
  int id;
  String title;
  String description;
  int pageCount;
  String excerpt;
  DateTime publishDate;

  BookModel({
    required this.id,
    required this.title,
    required this.description,
    required this.pageCount,
    required this.excerpt,
    required this.publishDate,
  });

  factory BookModel.fromJson(Map<String, dynamic> json) => BookModel(
    id: json["id"],
    title: json["title"],
    description: json["description"],
    pageCount: json["pageCount"],
    excerpt: json["excerpt"],
    publishDate: DateTime.parse(json["publishDate"]),
  );

  Map<String, dynamic> toJson() => {
    "id": id,
    "title": title,
    "description": description,
    "pageCount": pageCount,
    "excerpt": excerpt,
    "publishDate": publishDate.toIso8601String(),
  };
}
