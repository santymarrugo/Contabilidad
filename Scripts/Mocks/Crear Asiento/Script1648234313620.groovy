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
import com.sun.net.httpserver.Authenticator.Failure

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/**
 * Fecha : 25-03-2022
 * QA :  Santiago Marrugo
 *
 * 
 */


println("----- ID 3 -----")
//Vamos a crear el mes de asientos con fecha de 01/2020, para despues realizar la diferencia de cambio
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Asientos'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonCrearMesAsiento'))
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), '01/2020')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(3)

//Asientos de una linea - Linea 1
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(0,5,"11")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,6,"1112022")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,7,"4101")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(0,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,10,"AsientoA")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,12,"100")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,13,"0")', null)

for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
/**
 * Este paso tiene un BUG 228328, no agrega correctamente la cotizacion
 */
//WebUI.executeJavaScript('hot.setDataAtCell(0,18,"44.00")', null)

//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,19,"I")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)


//Asientos de una linea - Linea 2
WebUI.executeJavaScript('hot.selectCell(1,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(1,5,"11")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,6,"1112022")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,7,"4101")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(1,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,10,"AsientoB")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,12,"100")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,13,"0")', null)

for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
/**
 * Este paso tiene un BUG 228328, no agrega correctamente la cotizacion
 */
//WebUI.executeJavaScript('hot.setDataAtCell(1,18,"44.00")', null)

//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,19,"E")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)


//Asientos de una linea - Linea 3
WebUI.executeJavaScript('hot.selectCell(2,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(2,5,"11")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,6,"1112022")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,7,"4101")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(2,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,10,"AsientoC")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,12,"100")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,13,"0")', null)

for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
/**
 * Este paso tiene un BUG 228328, no agrega correctamente la cotizacion
 */
//WebUI.executeJavaScript('hot.setDataAtCell(2,18,"44")', null)

//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,19,"I")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)

//Asientos de una linea - Linea 4
WebUI.executeJavaScript('hot.selectCell(3,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(3,5,"11")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,6,"1112022")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,7,"4101")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(3,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,10,"AsientoD")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,12,"100")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,13,"0")', null)

for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
/**
 * Este paso tiene un BUG 228328, no agrega correctamente la cotizacion
 */
//WebUI.executeJavaScript('hot.setDataAtCell(3,18,"44")', null)

//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,19,"I")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)




//Asientos de una linea - Linea 5
WebUI.executeJavaScript('hot.selectCell(4,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(4,5,"11")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,6,"1112022")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,7,"4101")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(4,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,10,"AsientoE")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,12,"100")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,13,"0")', null)

for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
/**
 * Este paso tiene un BUG 228328, no agrega correctamente la cotizacion
 */
WebUI.executeJavaScript('hot.setDataAtCell(4,18,"44")', null)

WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,19,"I")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))













//Iniciamos sesion en Conty con la empresa Conty Automatizacion
//Iniciamos sesion
//WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)
//WebUI.delay(1)
////Procedemos a crear un nuevo mes de asientos
//WebUI.click(findTestObject('null'))
//WebUI.delay(1)
//WebUI.click(findTestObject('null'))
//WebUI.delay(1)
//WebUI.click(findTestObject('null'))
//WebUI.delay(1)
//WebUI.click(findTestObject('Object Repository/Mocks/BotonAceptarAsientos'))
//WebUI.delay(1)
//
//def columnasOcultas = WebUI.verifyElementPresent(findTestObject('Mocks/LabelCabeceraColumna_Sffffffffffff'), 5)
//println(columnasOcultas)

//def String Dia = WebUI.executeJavaScript('return hot.getSelected()', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String Debe = WebUI.executeJavaScript('return hot.getSelected()', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String Haber = WebUI.executeJavaScript('return hot.getSelected()', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String RUT = WebUI.executeJavaScript('return hot.getSelected()', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String S = WebUI.executeJavaScript('return hot.getSelected()', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String Concepto = WebUI.executeJavaScript('return hot.getSelected()', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String M = WebUI.executeJavaScript('return hot.getSelected()', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String Total = WebUI.executeJavaScript('return hot.getSelected()', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String N = WebUI.executeJavaScript('return hot.getSelected()', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String IVA = WebUI.executeJavaScript('return hot.getSelected()', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String Cotizacion = WebUI.executeJavaScript('return hot.getSelected()', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String L = WebUI.executeJavaScript('return hot.getSelected()', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String Tipo = WebUI.executeJavaScript('return hot.getSelected()', null)
//
//println("Dia "+ Dia)//[[0, 5, 0, 5]]
//println("Debe "+ Debe1)//[[0, 6, 0, 6]]
//println("Haber "+ Haber1)//[[0, 7, 0, 7]]
//println("RUT "+ RUTa)//[[0, 8, 0, 8]]
//println("S"+ S)//[[0, 9, 0, 9]]
//println("Concepto "+ Concepto)//[[0, 10, 0, 10]]
//println("M "+ M1)//[[0, 11, 0, 11]]
//println("Total "+ Total)//[[0, 12, 0, 12]]
//println("N "+ Na)//[[0, 13, 0, 13]]
//println("IVA "+ IVA)//[[0, 14, 0, 14]]
//println("Cotizacion "+ Cotizacion)//[[0, 18, 0, 18]]
//println("L "+ L1)//[[0, 19, 0, 19]]
//println("Tipo "+ Tipo1)//[[0, 21, 0, 21]]


//------------------------->
//Siguiente linea del mismo asiento
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
//WebUI.delay(1)
//WebUI.executeJavaScript('hot.selectCell(8,5)', null)
//WebUI.delay(1)
//WebUI.executeJavaScript('hot.setDataAtCell(8,5,"4")', null)
//for(i=0; i<2; i++) {
//	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//}
//WebUI.executeJavaScript('hot.setDataAtCell(8,7,"41211")', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//WebUI.executeJavaScript('hot.setDataAtCell(8,9,"1")', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//WebUI.executeJavaScript('hot.setDataAtCell(8,10,"PruebaVariasLineas_5")', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//WebUI.executeJavaScript('hot.setDataAtCell(8,11,"0")', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//WebUI.executeJavaScript('hot.setDataAtCell(8,12,"21500")', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//for(i=0; i<3; i++) {
//	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//}
//WebUI.executeJavaScript('hot.setDataAtCell(8,19,"I")', null)
//WebUI.delay(1)
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
//WebUI.delay(2)
//WebUI.verifyTextPresent('Se ha detectado un asiento con error.', false)
//WebUI.verifyTextPresent('Error: "El asiento no está balanceado."', false)
//WebUI.delay(1)
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
//WebUI.delay(1)
////Vamos a corregir el valos de $9.000 por $10.000 para que el asiento balancee
//WebUI.executeJavaScript('hot.selectCell(3,12)', null)
//WebUI.delay(1)
//WebUI.executeJavaScript('hot.setDataAtCell(0,12,"21500")', null)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//WebUI.delay(1)
////Validamos el asiento
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
//WebUI.delay(2)
//WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)

//Eliminamos las lineas del asiento para efectos de la Regresion
//WebUI.executeJavaScript('hot.selectRows(0,1)', null)
//WebUI.delay(1)
//WebUI.click(findTestObject('_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
//WebUI.delay(1)
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
//WebUI.delay(1)
//WebUI.verifyTextNotPresent('11111', false)
//WebUI.delay(1)
//WebUI.verifyTextNotPresent('11112', false)
//WebUI.delay(1)
//
//WebUI.executeJavaScript("alert('AQUI TERMINA EL TEST')", null)
//WebUI.delay(3)
//
//WebUI.closeBrowser()






