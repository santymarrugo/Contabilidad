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
 * Fecha creacion : 13-06-2022
 * QA : Santiago Marrugo
 */

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
//Moneda uno dolares
WebUI.selectOptionByValue(findTestObject('_Conty/Menu Principal/Informes/Diarios/DDMonedaUno'), '2', false)
WebUI.delay(1)
//Moneda dos euros
WebUI.selectOptionByValue(findTestObject('_Conty/Menu Principal/Informes/Diarios/DDMonedaDos'), '9', false)
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

//Verificamos que el reporte se haya generado
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTituloReporte-Diario-A-2M-DE'))
println(tituloReporte)
assert tituloReporte == 'Diario analítico'

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelPeriodoReporte Diario A-2M-DE'))
println(periodoReporte)
assert periodoReporte == '01/01/2022 a 31/01/2022. US$ y €'

//Verificamos la primer linea del reporte por el concepto de Transporte
def String labelTransporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTransporte'))
println(labelTransporte)
assert labelTransporte == 'Transporte'

//Verificamos los ceros en cada una de las columnas del debe y haber en las dos monedas
def String debeUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorDebeUSD'))
println(debeUSD)
assert debeUSD == '0.00'
def String haberUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorHaberUSD'))
println(haberUSD)
assert haberUSD == '0.00'
def String debeEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorDebeEUR'))
println(debeEUR)
assert debeEUR == '0.00'
def String haberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorHaberEUR'))
println(haberEUR)
assert haberEUR == '0.00'

//Verificamos los valores de los 3 asientos
//Fecha de los asientos
WebUI.verifyTextPresent('05/01/2022', false)
//Valores de la primera linea
def String linea1DebeUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL1DebeUSD'))
println(linea1DebeUSD)
assert linea1DebeUSD == '348.80'
def String linea1DebeEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL1DebeEUR'))
println(linea1DebeEUR)
assert linea1DebeEUR == '309.23'

//Valores de la segunda linea
def String linea2HaberUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL2HaberUSD'))
println(linea2HaberUSD)
assert linea2HaberUSD == '62.83'
def String linea2HaberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL2HaberEUR'))
println(linea2HaberEUR)
assert linea2HaberEUR == '55.70'

//Valores de la tercera linea
def String linea3HaberUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL3HaberUSD'))
println(linea3HaberUSD)
assert linea3HaberUSD == '285.97'
def String linea3HaberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL3HaberEUR'))
println(linea3HaberEUR)
assert linea3HaberEUR == '253.53'

//Validar linea de los totales
def String lineaTotalDebeUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/TotalDebeUSD'))
println(lineaTotalDebeUSD)
assert lineaTotalDebeUSD == '348.80'
def String lineaTotalHaberUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/TotalHaberUSD'))
println(lineaTotalHaberUSD)
assert lineaTotalHaberUSD == '348.80'
def String lineaTotalDebeEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/TotalDebeEUR'))
println(lineaTotalDebeEUR)
assert lineaTotalDebeEUR == '309.23'
def String lineaTotalHaberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/TotalHaberEUR'))
println(lineaTotalHaberEUR)
assert lineaTotalHaberEUR == '309.23'

