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
 * Fecha creacion : 08-06-2022
 * QA : Santiago Marrugo
 */

//Iniciamos sesion y accedemos a Balances
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Informes/Accesos a informes/Balances'), null)
WebUI.delay(1)
//Tipo de balance
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDTipoDeBalance'), '7', false)
WebUI.delay(1)
//Fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'), '01/01/2020')
//Fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'), '31/12/2021')
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'))
WebUI.delay(1)
//Moneda dolares
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDMonedaUno'), '2', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/BotonAceptarPopupBalance'))
WebUI.delay(15)
//Verificamos las 4 columnas que deben estar en el reporte
WebUI.verifyTextPresent('Débitos U$S', false)
WebUI.verifyTextPresent('Créditos U$S', false)
WebUI.verifyTextPresent('Deudores U$S', false)
WebUI.verifyTextPresent('Acreedores U$S', false)
WebUI.verifyTextPresent('Activo U$S', false)
WebUI.verifyTextPresent('Pasivo U$S', false)
WebUI.verifyTextPresent('Pérdidas U$S', false)
WebUI.verifyTextPresent('Ganancias U$S', false)
WebUI.delay(1)
//Verificamos la generacion correcta del reporte
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/LabelTituloReporte Balance 8COL-1M-D'))
println(tituloReporte)
assert tituloReporte == 'Balance 8 columnas'

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/LabelPeriodoReporte Balance 8COL-1M-D'))
println(periodoReporte)
assert periodoReporte == '01/01/2020 a 31/12/2021. U$S'

WebUI.delay(2)

WebUI.executeJavaScript('alert("Reporte generado con exito")', null)
WebUI.delay(3)

WebUI.closeBrowser()
