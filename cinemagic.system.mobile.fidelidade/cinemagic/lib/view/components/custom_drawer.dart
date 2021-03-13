import 'package:cinemagic/view/components/custom_drawer_header.dart';
import 'package:flutter/material.dart';

class CustomDrawer extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ClipRRect(
      borderRadius: BorderRadius.horizontal(right: Radius.circular(50)),
      child: Drawer(
        child: ListView(
          children: [CustomDrawerHeader()],
        ),
      ),
    );
  }
}
