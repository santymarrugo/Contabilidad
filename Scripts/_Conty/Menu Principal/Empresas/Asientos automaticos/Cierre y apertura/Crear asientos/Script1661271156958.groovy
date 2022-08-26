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
import com.kms.katalon.core.util.KeywordUtil as KWU

/**
 * Fecha creacion : 24-08-2022
 * QA : Santiago Marrugo
 */

//Vamos a ingresar a la opicion asientos
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIzquierdoAsientos'))
WebUI.delay(1)
WebUI.verifyElementPresent(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/LabelTituloPopupAsientos'), 5)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputAnioAsiento'))
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputAnioAsiento'), Keys.chord(Keys.CONTROL,'a'))
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputAnioAsiento'), Keys.chord(Keys.BACK_SPACE))
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputAnioAsiento'), '2022')
WebUI.delay(0.5)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonCrearMesAsiento'))
WebUI.delay(0.5)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'))
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.CONTROL,'a'))
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.BACK_SPACE))
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), '02/2022')
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(1)

//Vamos a realizar los asientos
WebUI.executeJavaScript('hot.selectCell(0, 5)', null)
//Fila 1
KWU.logInfo('Fila 1')
WebUI.executeJavaScript('hot.setDataAtCell(0, 5, "3")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(0, 6, "53116")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(0, 7, "11111")', null)
for(i=0; i<2; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(0, 9, "1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(0, 10, "Gasto1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(0, 11, "0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(0, 12, "8950")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(0, 13, "8")', null)
for(i=0; i<2; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(0, 18, "40")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(0, 19, "E")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))

//Fila 2
KWU.logInfo('Fila 2')
WebUI.executeJavaScript('hot.setDataAtCell(1, 5, "5")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(1, 6, "53115")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(1, 7, "11112")', null)
for(i=0; i<2; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(1, 9, "1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(1, 10, "Gasto2")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(1, 11, "0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(1, 12, "3410")', null)
for(i=0; i<3; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(1, 18, "38.5")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(1, 19, "E")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))

//Fila 3
KWU.logInfo('Fila 3')
WebUI.executeJavaScript('hot.setDataAtCell(2, 5, "8")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(2, 6, "53114")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(2, 7, "21111")', null)
for(i=0; i<2; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(2, 9, "1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(2, 10, "Gasto3")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(2, 11, "0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(2, 12, "17500")', null)
for(i=0; i<3; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(2, 18, "0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(2, 19, "E")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))

//Fila 4
KWU.logInfo('Fila 4')
WebUI.executeJavaScript('hot.setDataAtCell(3, 5, "9")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(3, 6, "53112")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(3, 7, "21111")', null)
for(i=0; i<2; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(3, 9, "1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(3, 10, "Gasto4")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(3, 11, "0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(3, 12, "1000")', null)
for(i=0; i<4; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(3, 19, "E")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))

//Fila 5
KWU.logInfo('Fila 5')
WebUI.executeJavaScript('hot.setDataAtCell(4, 5, "14")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4, 6, "11111")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4, 7, "41113")', null)
for(i=0; i<2; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(4, 9, "1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4, 10, "Venta1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4, 11, "0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4, 12, "11500")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(4, 13, "9")', null)
for(i=0; i<3; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(4, 19, "I")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))

//Fila 6
KWU.logInfo('Fila 6')
WebUI.executeJavaScript('hot.setDataAtCell(5, 5, "17")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(5, 6, "11112")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(5, 7, "41113")', null)
for(i=0; i<2; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(5, 9, "1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(5, 10, "Venta2")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(5, 11, "0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(5, 12, "24000")', null)
for(i=0; i<4; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(5, 19, "I")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))

//Fila 7
KWU.logInfo('Fila 7')
WebUI.executeJavaScript('hot.setDataAtCell(6, 5, "18")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(6, 6, "1112012")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(6, 7, "41114")', null)
for(i=0; i<2; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(6, 9, "1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(6, 10, "Venta3")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(6, 11, "0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(6, 12, "6120")', null)
for(i=0; i<4; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(6, 19, "I")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))

//Fila 8
KWU.logInfo('Fila 8')
WebUI.executeJavaScript('hot.setDataAtCell(7, 5, "19")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(7, 6, "1112011")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(7, 7, "41114")', null)
for(i=0; i<2; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(7, 9, "1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(7, 10, "Venta4")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(7, 11, "0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
WebUI.executeJavaScript('hot.setDataAtCell(7, 12, "33000")', null)
for(i=0; i<4; i++) {WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))}
WebUI.executeJavaScript('hot.setDataAtCell(7, 19, "V")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))

//Validamos los asientos creados
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(1)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
