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
 * Fecha creacion : 29-06-2022
 * QA : Santiago Marrugo
 */

//Accedemos a la opcion Asientos
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIzquierdoAsientos'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(0.5)
WebUI.verifyTextNotPresent('2/2022', false)
WebUI.delay(0.5)
//Seleccionamos mes del Asiento - 02/2022
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonCrearMesAsiento'))
WebUI.delay(0.5)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'))
WebUI.delay(0.5)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.delay(0.5)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(0.5)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), '02/2022')
WebUI.delay(0.5)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(0.5)
WebUI.verifyTextPresent('Asientos 02/2022', false)
WebUI.delay(1)
WebUI.verifyTextPresent('Debe', false)
WebUI.delay(1)
//Creamos el Asiento
//Linea 1
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(0,5,"5")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,6,"531118")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(0,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,10,"Ejemplo Gastos Honorarios Prof")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,12,"2500")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,13,"2")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(0,19,"C")', null)

//Linea 2
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.selectCell(1,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(1,5,"5")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(1,7,"21111")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(1,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,10,"Ejemplo Gastos Honorarios Prof")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,12,"2500")', null)
for(i=0; i<4; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(1,19,"C")', null)

//Linea 3
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.selectCell(2,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(2,5,"8")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,6,"21111")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(2,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,10,"Honorarios prof EXTORNO")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,12,"1000")', null)
for(i=0; i<4; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(2,19,"C")', null)

//Linea 4
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.selectCell(3,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(3,5,"8")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(3,7,"531118")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(3,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,10,"Honorarios prof EXTORNO")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,12,"1000")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,13,"2")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(3,19,"C")', null)

//Linea 5
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.selectCell(4,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(4,5,"9")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,6,"531117")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,7,"11111")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(4,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,10,"Ejemplo Servicios varios ok")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,12,"5000")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(4,13,"1")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(4,19,"C")', null)

//Linea 6
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.selectCell(5,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(5,5,"10")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(5,6,"11111")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(5,7,"531117")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(5,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(5,10,"Servicios varios EXTORNO")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(5,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(5,12,"800")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(5,13,"1")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(5,19,"C")', null)

//Terminamos el Asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(1)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(0.5)
WebUI.verifyTextPresent('2/2022', false)
