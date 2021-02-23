import 'package:cinemagic/view/home/utils/tile_filter.dart';
import 'package:flutter/material.dart';

class RegionFilter extends StatefulWidget {
  @override
  _RegionFilterState createState() => _RegionFilterState();
}

class _RegionFilterState extends State<RegionFilter> {
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.symmetric(horizontal: 12),
      height: 50,
      color: Colors.transparent,
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          TileFilter(
            title: "País",
            iconData: Icons.filter_list,
          ),
          TileFilter(
            title: "Estado",
            iconData: Icons.filter_list,
          ),
          TileFilter(
            title: "Cidade",
            iconData: Icons.filter_list,
          )
        ],
      ),
    );
  }
}
