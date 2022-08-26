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
 * Fecha creacion : 01-07-2022
 * QA : Santiago Marrugo
 */

//Tipo de balance
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDTipoDeBalance'), '3', false)
WebUI.delay(1)
//Fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'), '01/02/2022')
//Fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'), '28/02/2022')
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'))
//Importes en una moneda
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDImportesEn'), '1', false)
WebUI.delay(1)
//Moneda pesos
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDMonedaUno'), '1', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/BotonAceptarPopupBalance'))
WebUI.delay(5)

//Verificamos la generacion correcta del reporte
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Balance/LabelTituloReporte Balance COM-1M-P'))
println(tituloReporte)
assert tituloReporte == 'Balance completo'

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Balance/LabelPeriodoReporte Balance COM-1M-P'))
println(periodoReporte)
assert periodoReporte == '01/02/2022 a 28/02/2022. $'

WebUI.verifyTextPresent('Descripción', false)

//Verificamos los valores del reporte
def String totalActivo = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Balance/TotalActivo'))
println(totalActivo)
def String totalPasivo = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Balance/TotalPasivo'))
println(totalPasivo)
def String pasivoMasPatrimonio = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Balance/PasivoMasPatrimonio'))
println(pasivoMasPatrimonio)
def String resultadoPasivoMasPatrimonio = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Balance/ResultadoPasivoMasPatrimonio'))
println(resultadoPasivoMasPatrimonio)
def String totalPerdidas = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Balance/TotalPerdidas'))
println(totalPerdidas)
def String resultadoPerdidas = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Balance/ResultadoPerdidas'))
println(resultadoPerdidas)

assert (totalActivo == '-3,547.69' && totalPasivo == '1,500.00' && pasivoMasPatrimonio == '-1,500.00' && resultadoPasivoMasPatrimonio == '-5,047.69' 
&& totalPerdidas == '5,047.69' && resultadoPerdidas == '-5,047.69')


