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
 * Fecha creacion : 21-06-2022
 * QA : Santiago Marrugo
 */

//Seleccionamos el libro
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDLibro'), '3', false)
WebUI.delay(1)
//Las fechas
//Inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'), '01/01/2022')
WebUI.delay(1)
//Final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'), '31/01/2022')
WebUI.delay(1)
//Ubicamos el foco nuevamente en la fecha inicial para que se active el boton Aceptar
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'))
//La moneda dolares
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDMoneda'), '2', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/BotonAceptarPopupSubdiarios'))
WebUI.delay(5)

//Verificamos que se haya generado sin tener en cuenta los valores del Reporte
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTituloReporte-Subdiario L-I-D'))
println(tituloReporte)
assert tituloReporte == 'Libro de Ingresos'
WebUI.delay(1)

def String periodoReporte = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelPeriodoReporte Subdiario L-I-D'))
println(periodoReporte)
assert periodoReporte == '01/01/2022 a 31/01/2022 en US$'

WebUI.verifyTextPresent('Monto US$', false)
WebUI.delay(1)

//Verificamos las fechas de los asientos
def String diaLinea1 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea1SubD L-I-D'))
println(diaLinea1)
def String diaLinea2 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea2SubD L-I-D'))
println(diaLinea2)
def String diaLinea3 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea3SubD L-I-D'))
println(diaLinea3)

assert diaLinea1 == '05/01/22' && diaLinea2 == '05/01/22' && diaLinea3 == '05/01/22'

//Valores linea 1
def String totalUSDL1 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotal-L1-USD-SubD-L-I-D'))
println(totalUSDL1)
assert totalUSDL1 == '348.80'

//Valores linea 2
def String montoUSDL2 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorMontoUSD-L2-SubD-L-I-D'))
println(montoUSDL2)
assert montoUSDL2 == '285.97'

//Valores linea 3
def String ivaUSDL3 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorIVA-L3-USD-SubD-L-I-D'))
println(ivaUSDL3)
assert ivaUSDL3 == '62.83'

//Exento
def String exMontoUSD = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorExentoMontoEUR-SubD L-I-E'))
println(exMontoUSD)
assert exMontoUSD == '286.00'//Aqui el valor debe ser 285.97 reportado en el bug # 246453

def String exTotalUSD = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorExentoTotalUSD-SubD L-I-D'))
println(exTotalUSD)
assert exTotalUSD == '286.00'//Aqui el valor debe ser 285.97 reportado en el bug # 246453

//IVA Ventas
def String ivaVenUSD = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorIVAVentasUSD-SubD-L-I-D'))
println(ivaVenUSD)
def String ivaTotalUSD = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorIVAVentasTotalUSD-SubD-L-I-D'))
println(ivaTotalUSD)

assert ivaTotalUSD == '62.83' && ivaVenUSD == '62.83'

//Total General
def String totalGenMontoUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalGenMontoUSD-SubD-L-I-D'))
println(totalGenMontoUSD)
def String totalGenIVAUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalGenIVAUSD SubD-L-I-D'))
println(totalGenIVAUSD)
def String totalGenUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalGeneralUSD-SubD-L-I-D'))
println(totalGenUSD)

assert totalGenMontoUSD == '285.97' && totalGenIVAUSD == '62.83' && totalGenUSD == '348.80'
