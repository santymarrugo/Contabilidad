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
 * Fecha creacion : 09-06-2022
 * QA : Santiago Marrugo
 */

//Tipo de balance
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDTipoDeBalance'), '1', false)
WebUI.delay(1)
//Fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'), '01/01/2022')
//Fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'), '31/01/2022')
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'))
//Importes en dos monedas
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDImportesEn'), '2', false)
WebUI.delay(1)
//Moneda uno dolares
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDMonedaUno'), '2', false)
WebUI.delay(1)
//Moneda dos Euros
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDMonedaDos'), '9', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/BotonAceptarPopupBalance'))
WebUI.delay(5)

//Verificamos la generacion correcta del reporte
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTituloReporte-2M-EDS-DE'))
println(tituloReporte)
assert tituloReporte == 'Estado de situación'

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelPeriodoReporte-Balance EDS-2M-DE'))
println(periodoReporte)
assert periodoReporte == '01/01/2022 a 31/01/2022. US$ y €'

//Total activo
def String labelTotalACTIVO = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTotalACTIVO'))
println(labelTotalACTIVO)
//Total saldo en dolares
def String totalSaldoACTIVOUsd = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTotalACTIVO_SaldoUSD'))
//Total saldo en Euros
def String totalSaldoACTIVOEur = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTotalACTIVO_SaldoEUR'))
assert labelTotalACTIVO == 'Total ACTIVO' && totalSaldoACTIVOUsd == '348.80' && totalSaldoACTIVOEur == '309.23'

//Total pasivo
def String labelTotalPASIVO = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTotalPASIVO'))
println(labelTotalPASIVO)
//Total saldo en dolares
def String totalSaldoPASIVOUsd = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTotalPASIVO_SaldoUSD'))
//Total saldo en Euros
def String totalSaldoPASIVOEur = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTotalPASIVO_SaldoEUR'))
assert labelTotalPASIVO == 'Total PASIVO' && totalSaldoPASIVOUsd == '62.83' && totalSaldoPASIVOEur == '55.70'

//Verificamos el Pasivo + Patrimonio
def String labelPasivoMasPatrimonio = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelPatrimonioMasPasivo'))
println(labelPasivoMasPatrimonio)
def String patrimonioMasPasivoUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/PasivoMasPatrimonioUSD'))
def String patrimonioMasPasivoEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/PasivoMasPatrimonioEUR'))
assert labelPasivoMasPatrimonio == 'Pasivo + Patrimonio' && patrimonioMasPasivoUSD == '62.83' && patrimonioMasPasivoEUR == '55.70'

//Verificamos el Resultado, El RESULTADO es igual al Total ACTIVO menos (Pasivo + Patrimonio) en DOLARES
def String labelResultado = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelResultado'))
println(labelResultado)
assert labelResultado == 'Resultado'
def float f_totalSaldoACTIVOUsd = Float.parseFloat(totalSaldoACTIVOUsd)
def float f_patrimonioMasPasivoUSD = Float.parseFloat(patrimonioMasPasivoUSD)
def float ResultadoUSD = f_totalSaldoACTIVOUsd - f_patrimonioMasPasivoUSD
//Redondeamos el valor flotante porque trae muchos decimales y necesitamos solo dos
def float resultadoFinalUSD = Math.round(ResultadoUSD * 100) / 100
println(resultadoFinalUSD)
assert resultadoFinalUSD == Float.parseFloat('285.97')

//Verificamos el Resultado, El RESULTADO es igual al Total ACTIVO menos (Pasivo + Patrimonio) en EUROS
def float f_totalSaldoACTIVOEur = Float.parseFloat(totalSaldoACTIVOEur)
def float f_patrimonioMasPasivoEUR = Float.parseFloat(patrimonioMasPasivoEUR)
def float ResultadoEUR = f_totalSaldoACTIVOEur - f_patrimonioMasPasivoEUR
//Redondeamos el valor flotante porque trae muchos decimales y necesitamos solo dos
def float resultadoFinalEUR = Math.round(ResultadoEUR * 100) / 100
println(ResultadoEUR)
println(resultadoFinalEUR)
assert resultadoFinalEUR == Float.parseFloat('253.53')
