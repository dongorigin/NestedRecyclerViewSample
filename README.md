# NestedRecyclerViewSample
Nested RecyclerView sometimes not rebind view after notifyDataSetChanged

![recurrence](https://github.com/dongorigin/NestedRecyclerViewSample/blob/master/screenshots/reproduce_setps.gif)

### Steps to reproduce 
1. launch activity
2. scroll down to item:10, close to item:11
3. scroll up to item:1
4. item:1's child item display error.

### Frequency 
100%

### Expected output 
Item:1's child item 1 and 2 display "row:1 col0" and "row:1 col1".  
Nested child RecyclerView's adapter correctly call onBindViewHolder after notifyDataSetChanged.

### Current output 
Item:1's child item 1 and 2 display "row:11 col0" and "row:11 col1".  
Nested child RecyclerView's adapter not call onBindViewHolder after notifyDataSetChanged, causing item to display error.

### Environment
- device: Nexus 5  
- os: Android 6.0.1  
- ide: Android Studio 2.3.1  
- dependencies: support 25.3.1
