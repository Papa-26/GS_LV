[Return](Block_Diagram.md)
## view ##
[Block Diagram of G_String](img/block.png)

The package ['view'](../../../tree/main/workbench/GS_L/src/view) handles the graphical user interface. The file ['rootLayout.fxml'](../../../blob/main/workbench/GS_L/src/view/RootLayout.fxml) defines the display screen of GS, and['rootLayoutController.java'](../../../blob/main/workbench/GS_L/src/view/RootLayoutController.java') defines its behaviour. the method 'initialize' (line # 86) sets the links for various menu responses to appropriate methods. Those methods with the prefix 'myMain.' are situated in object 'Main' (application). Those without a prefix are within rootLayoutController.

The screen serves as a stage that displays the scenes generated by 'AnaGroups' or 'SynthGroups' respectively.

Also in 'view' is ['TextStack.java'](../../../blob/main/workbench/GS_L/src/view/TextStack.java) that reads the help text files appropriate for analysis or synthesis, and the appropriate step, interprets the markup, thus generating JavaFX VBoxes that are displayed.