import "package:flutter/material.dart";

class TextCommonLogin extends StatelessWidget {
  final String title;
  TextCommonLogin({this.title});
  @override
  Widget build(BuildContext context) {
    return Text(
      '$title',
      style: TextStyle(
        color: Colors.grey[800],
        fontSize: 16,
        fontWeight: FontWeight.w700,
      ),
    );
  }
}
