import 'package:flutter/material.dart';

class TileFilter extends StatelessWidget {
  TileFilter({this.title, this.iconData});
  final String title;
  final IconData iconData;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      child: Wrap(
        children: [Text('$title'), Icon(iconData)],
      ),
    );
  }
}
