// To parse this JSON data, do
//
//     final bookListModel = bookListModelFromJson(jsonString);

import 'dart:convert';

List<BookListModel> bookListModelFromJson(String str) => List<BookListModel>.from(json.decode(str).map((x) => BookListModel.fromJson(x)));

String bookListModelToJson(List<BookListModel> data) => json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

class BookListModel {
  int id;
  String title;
  String description;
  int pageCount;
  String excerpt;
  DateTime publishDate;

  BookListModel({
    required this.id,
    required this.title,
    required this.description,
    required this.pageCount,
    required this.excerpt,
    required this.publishDate,
  });

  factory BookListModel.fromJson(Map<String, dynamic> json) => BookListModel(
    id: json["id"],
    title: json["title"],
    description: json["description"]!,
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
