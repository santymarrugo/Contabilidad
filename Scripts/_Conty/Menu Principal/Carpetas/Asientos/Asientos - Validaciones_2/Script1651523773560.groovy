import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/**
 * Fecha creacion : 2-05-2022
 * QA : Santiago Marrugo
 * Este test es la continuacion del test Asientos - Validaciones
 */

println("<----- ID 9 ----->")
//Primera linea de asiento de multiples lineas
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(2)
//Verificamos que estemos en el mes de asiento correcto
WebUI.verifyTextPresent('PruebaPrimerAsiento', false)
WebUI.verifyTextPresent('PruebaVariasLineas_3', false)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(9,5)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(9,5,"4")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(9,6,"11211")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(9,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(9,10,"PruebaVariasLineas_4")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(9,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(9,12,"21470")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(9,19,"I")', null)
WebUI.delay(1)

//Siguiente linea del mismo asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(10,5)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(10,5,"4")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(10,7,"41211")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(10,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(10,10,"PruebaVariasLineas_5")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(10,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(10,12,"21500")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(10,19,"I")', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Se ha detectado un asiento con error.', false)
WebUI.verifyTextPresent('Error: "El asiento no está balanceado."', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)
//Vamos a corregir el valor de $21.470 por $21.500 para que el asiento balancee
WebUI.executeJavaScript('hot.selectCell(0,12)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(0,12,"21500")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.delay(1)
//Validamos el asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)

println("<----- ID 10 ----->")
//Primera linea de asiento de multiples lineas
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(2)
//Verificamos que estemos en el mes de asiento correcto
WebUI.verifyTextPresent('PruebaPrimerAsiento', false)
WebUI.verifyTextPresent('PruebaVariasLineas_5', false)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(11,5)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(11,5,"6")', null)
for(i=0; i<4; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(11,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(11,10,"PruebaVariasLineas_6")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(11,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(11,12,"2000")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(11,19,"I")', null)
WebUI.delay(1)
//Validamos el asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
//Nos muestra el popup de errores en el asiento
WebUI.verifyTextPresent('Aviso: "La fila de un asiento está incompleta y no se guardará el cambio."', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(0,6)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(0,6,"11211")', null)
WebUI.delay(1)
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIzquierdoAsientos'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(5)
WebUI.executeJavaScript('hot.selectCell(11,5)', null)

//Siguiente linea del mismo asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(1,5)', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(12,5,"6")', null)
for(i=0; i<4; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(12,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(12,10,"PruebaVariasLineas_7")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(12,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(12,12,"2000")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(12,19,"I")', null)
WebUI.delay(1)
//Validamos el asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
//Nos muestra el popup de errores en el asiento
WebUI.verifyTextPresent('Se detectaron errores y avisos en los asientos.', false)
WebUI.verifyTextPresent('¿Desea corregirlos ahora?', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(1,7)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(1,7,"41211")', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)

println("<----- ID 11 ----->")
//ESTA PARTE AUN NO ESTA DESARROLLADA SE VA A TRABAJAR EN LA US 209824
//Primera linea de asiento de multiples lineas
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(2)
//Verificamos que estemos en el mes de asiento correcto
WebUI.verifyTextPresent('PruebaPrimerAsiento', false)
WebUI.verifyTextPresent('PruebaVariasLineas_7', false)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(13,5)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(13,5,"7")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(13,6,"11211")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(13,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(13,10,"PruebaCotizacion")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(13,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(13,12,"30000")', null)
for(i=0; i<4; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(13,19,"I")', null)

//Siguiente linea del mismo asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(14,5)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(14,5,"7")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(14,6,"11211")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(14,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(14,10,"PruebaCotizacion_1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(14,11,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(14,12,"100")', null)
for(i=0; i<4; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(14,19,"I")', null)

//Siguiente linea del mismo asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(15,5)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(15,5,"7")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(15,7,"41113")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(15,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(15,10,"PruebaCotizacion_2")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(15,11,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(15,12,"250")', null)
for(i=0; i<4; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(15,19,"I")', null)

//Siguiente linea del mismo asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(16,5)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(16,5,"7")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(16,7,"41211")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(16,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(16,10,"PruebaCotizacion_3")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(16,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(16,12,"24000")', null)
for(i=0; i<4; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(16,19,"I")', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
//Actualmente aqui se senala en rojo la columna TOTAL, y deberia senalarse en rojo la columna Cotizacion, esto se trabajara en la US 209824
WebUI.verifyTextPresent('Se detectaron varios errores en asientos.', false)
WebUI.verifyTextPresent('¿Desea corregirlos ahora?', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)

//Se detectaron varios errores en asientos.
//¿Desea corregirlos ahora?

//Vamos corregir el dato en la columna de Cotizacion, para que el Asiento Balancee
WebUI.executeJavaScript('hot.selectCell(1,18)', null)
WebUI.executeJavaScript('hot.setDataAtCell(1,18,"40")', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(3,18)', null)
WebUI.executeJavaScript('hot.setDataAtCell(3,18,"40")', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(2)
//Verificamos que estemos en el mes de asiento correcto
WebUI.verifyTextPresent('PruebaPrimerAsiento', false)
WebUI.verifyTextPresent('PruebaCotizacion_3', false)
WebUI.delay(2)

println("<----- ID 12 ----->")
WebUI.executeJavaScript('hot.selectCell(16,5)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(17,5,"14")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(17,6,"11211")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(17,7,"41113")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(17,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(17,10,"PruebaLibroPconImp")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(17,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(17,12,"11550")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(17,13,"6")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(17,18,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(17,19,"P")', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
//Validamos que no se pueda hacer este asiento
WebUI.verifyTextPresent('Error: "Los asientos en una sola línea asignados a libros P o U no pueden llevar impuestos."', false)
WebUI.delay(1)
//Cambiamos el libro de P a U para que se valide el asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(0,19)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(0,19,"U")', null)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
//Validamos que no se pueda hacer este asiento
WebUI.verifyTextPresent('Error: "Los asientos en una sola línea asignados a libros P o U no pueden llevar impuestos."', false)
WebUI.delay(1)
//Cambiamos el libro de P a U para que se valide el asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(0,19)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(0,19,"I")', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(2)
//Verificamos que estemos en el mes de asiento correcto
WebUI.verifyTextPresent('PruebaPrimerAsiento', false)
WebUI.verifyTextPresent('PruebaLibroPconImp', false)
WebUI.delay(2)

println("<----- ID 13 ----->")
WebUI.executeJavaScript('hot.selectCell(17,5)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(18,5,"16")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(18,6,"11211")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(18,7,"41113")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(18,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(18,10,"PruebaLibroPconImp_1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(18,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(18,12,"1550")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(18,18,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(18,19,"X")', null)
WebUI.delay(1)
//Validamos el asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
//Nos muestra el popup de errores en el asiento
WebUI.verifyTextPresent('Se ha detectado un asiento con error.', false)
WebUI.verifyTextPresent('Error: "El código del libro no es válido."', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(0,19)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(0,19,"I")', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(2)
//Verificamos que estemos en el mes de asiento correcto
WebUI.verifyTextPresent('PruebaPrimerAsiento', false)
WebUI.verifyTextPresent('PruebaLibroPconImp_1', false)
WebUI.delay(2)

println("<----- ID 5 ----->")// TIENE UN BUG 221232
//Vamos a ingresar un codigo de IVA que no exista
WebUI.executeJavaScript('hot.selectCell(18,5)', null)//Esta coordenada de la fila debera ser 3 y se debera modificar cuando se solucione el BUG
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
//Ingresamos el quinto asiento de una sola linea
WebUI.executeJavaScript('hot.setDataAtCell(19,5,"16")', null)//Aqui la fila debe ser 4
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(19,6,"11211")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(19,7,"41113")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(19,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(19,10,"PruebaQuintoAsiento")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(19,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(19,12,"14500")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//Se ingresa un codigo de IVA que NO existe
WebUI.executeJavaScript('hot.setDataAtCell(19,13,"9")', null)
for(i=0; i<4; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(19,19,"C")', null)
//Y cerramos el asiento dando clic en el boton Terminar
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
//Hacemos click el el boton terminar para que se muestre el popup indicando que hay errores en la linea
WebUI.verifyTextPresent('Error: "El código del impuesto no es válido."', false)
WebUI.delay(2)
//Hacemos click en el boton SI del popup, para corregir el dato de la celda del Debe o haber
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(1)
//Seleccionamos la celda del codigo IVA e ingresamos el codigo correcto
WebUI.executeJavaScript('hot.selectCell(0,13)', null)
WebUI.executeJavaScript('hot.setDataAtCell(0,13,"2")', null)
//Y cerramos el asiento dando clic en el boton Terminar
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(1)
//Seleccionamos el mes de asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(2)
//Verificamos que estemos en el mes de asiento correcto
WebUI.verifyTextPresent('PruebaPrimerAsiento', false)
WebUI.verifyTextPresent('PruebaQuintoAsiento', false)
WebUI.delay(2)

//Eliminamos las lineas del asiento para efectos de la Regresion
WebUI.executeJavaScript('hot.selectRows(0,19)', null)
WebUI.delay(1)
WebUI.click(findTestObject('_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
WebUI.delay(1)
WebUI.verifyTextNotPresent('PruebaPrimerAsiento', false)
WebUI.delay(1)
WebUI.verifyTextNotPresent('PruebaQuintoAsiento', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.executeJavaScript("alert('AQUI TERMINA EL TEST')", null)
WebUI.delay(3)


WebUI.closeBrowser()
