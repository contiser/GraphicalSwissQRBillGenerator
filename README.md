# GraphicalSwissQRBillGenerator

A simple utility to generate QR Bills (very basic) comes with no warranties, it bases on manuelbl's project https://github.com/manuelbl/SwissQRBill

In order to use it, make sure you have a working Java installation on your pc (minimum version suggested: 11). 
If you still don't have it download the installer from here: https://www.oracle.com/java/technologies/downloads/#jdk19-windows

![Screenshot_Graphical_Swiss_QR_Bill_Generator](https://github.com/contiser/GraphicalSwissQRBillGenerator/blob/master/Screenshot.png?raw=true)

Remarks
1) At the moment I concentrated myself on making a very simple version, errors are still not displayed, if no document is generated check if the IBAN is correct and if the amount is a valid number.
2) The generator currently only supports normal IBAN numbers, the only difference is that if you'd like to use a QR IBAN then a reference code would be needed, which private users usually don't have, so I skipped that feature by now.
Improvements may arrive soon...
