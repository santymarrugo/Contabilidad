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
 * Fecha creacion : 20-05-2022
 * QA : Santiago Marrugo
 */

WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Informes/Accesos a Informes/Diarios'), null)
WebUI.delay(1)
//Seleccionamos el tipo de diario
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/DDTipoDiario'), '1', false)
WebUI.delay(1)
//Fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'), '01/01/2022')
WebUI.delay(1)
//Fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaFinal'), '31/01/2022')
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'))
WebUI.delay(1)
//Importes en dos monedas
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/DDImportesEn'), '2', false)
WebUI.delay(1)
//Moneda uno pesos
WebUI.selectOptionByValue(findTestObject('_Conty/Menu Principal/Informes/Diarios/DDMonedaUno'), '1', false)
WebUI.delay(1)
//Moneda dos dolares
WebUI.selectOptionByValue(findTestObject('_Conty/Menu Principal/Informes/Diarios/DDMonedaDos'), '2', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/DDApertura'), '0', false)
WebUI.delay(1)
//Orden
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/DDOrden'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/BotonAceptarPopupDiarios'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(5)
//Verificamos que el reporte se haya generado, sin tener en cuenta los valores del mismo
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/LabelTituloReporte-A-2M-PD'))
println(tituloReporte)
assert tituloReporte == 'Diario analítico'

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/LabelPeriodoReporte-A-2M-PD'))
println(periodoReporte)
assert periodoReporte == '01/01/2022 a 31/01/2022. $ y U$S'

WebUI.verifyTextPresent('Debe $', false)
WebUI.delay(1)
WebUI.executeJavaScript("alert('Reporte generado con Exito')", null)
WebUI.delay(3)

WebUI.closeBrowser()

