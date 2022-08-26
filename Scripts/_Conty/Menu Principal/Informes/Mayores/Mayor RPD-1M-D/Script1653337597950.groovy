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
 * Fecha creacion : 23-05-2022
 * QA : Santiago Marrugo
 */

WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Informes/Accesos a Informes/Mayores'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
//Tipo de mayor - Resumido por dia
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDTipoDeMayor'), '2', false)
WebUI.delay(1)
//Fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'), '01/01/2022')
WebUI.delay(1)
//Fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'), '31/01/2022')
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'))
WebUI.delay(1)
//Importes en una moneda
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDImportesEn'), '1', false)
WebUI.delay(1)
//Moneda en dolares
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDMonedaUno'), '2', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/BotonAceptarPopupMayores'))
WebUI.delay(15)

//Verificamos la generacion del reporte, sin validar los calculos del mismo
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/LabelTituloMayor RPD-1M-P'))
println(tituloReporte)
assert tituloReporte == 'Mayor Resumido por día'

def String periodoReporte = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Mayores/LabelPeriodoReporteMayor RPD-1M-D'))
println(periodoReporte)
assert periodoReporte == '01/01/2022 a 31/01/2022. U$S'
WebUI.verifyTextPresent('Saldo U$S', false)
WebUI.delay(1)
WebUI.executeJavaScript("alert('Reporte generado con exito')", null)

WebUI.delay(3)
WebUI.closeBrowser()