
var botao = $("#Finaliza");
var personalizadoBotao = $("#personalizado");
var cardapioBotao = $("#cardapio");
var alface = $("#alface");
var bacon = $("#bacon");
var hamburguer = $("#hamburguer");
var ovo = $("#ovo");
var queijo = $("#queijo");
var lancheSelect = $("#lanche_select");
var preco = $("#Preco");
var ingredientesAlface = $("#ingredientesAlface");
var ingredientesBacon = $("#ingredientesBacon");
var ingredientesHamburguer = $("#ingredientesHamburguer");
var ingredientesOvo = $("#ingredientesOvo");
var ingredientesQueijo = $("#ingredientesQueijo");

personalizadoBotao.click(function(){
  alface.prop("disabled", false);
  bacon.prop("disabled", false);
  hamburguer.prop("disabled", false);
  ovo.prop("disabled", false);
  queijo.prop("disabled", false);
  lancheSelect.prop("disabled", true);
  botao.prop("disabled", false);
  lancheSelect.val("");
  preco.text("");
})

cardapioBotao.click(function(){
  alface.prop("disabled", true);
  bacon.prop("disabled", true);
  hamburguer.prop("disabled", true);
  ovo.prop("disabled", true);
  queijo.prop("disabled", true);
  lancheSelect.prop("disabled", false);
  botao.prop("disabled", false);
  alface.val("");
  bacon.val("");
  hamburguer.val("");
  ovo.val("");
  queijo.val("");
  preco.text("");
})

botao.click(function(){
  ingredientesAlface.css("visibility","hidden");
  ingredientesBacon.css("visibility","hidden");
  ingredientesHamburguer.css("visibility","hidden");
  ingredientesOvo.css("visibility","hidden");
  ingredientesQueijo.css("visibility","hidden");

  var qtdAlface = alface.val();
  var qtdBacon = bacon.val();
  var qtdHamburguer = hamburguer.val();
  var qtdOvo = ovo.val();
  var qtdQueijo = queijo.val();

  var lanche = {
	lanchesPedidos: [
          {
            id: 1,
            ingredientesNomes: "ALFACE ".repeat(qtdAlface).split(" ").slice(0,qtdAlface).concat(
              "BACON ".repeat(qtdBacon).split(" ").slice(0,qtdBacon).concat(
                "HAMBURGUER ".repeat(qtdHamburguer).split(" ").slice(0,qtdHamburguer).concat(
                  "OVO ".repeat(qtdOvo).split(" ").slice(0,qtdOvo).concat(
                    "QUEIJO ".repeat(qtdQueijo).split(" ").slice(0,qtdQueijo)
                  )
                )
              )
            )
          }
	     ]
  }

  switch(Number($("#lanche_select").val())) {
    case 1:
      lanche = { lanchesPedidos: [ { id: 1, ingredientesNomes: ["BACON","HAMBURGUER","QUEIJO"] } ] };
      break;
    case 2:
      lanche = { lanchesPedidos: [ { id: 1, ingredientesNomes: ["HAMBURGUER","QUEIJO"] } ] };
      break;
    case 3:
      lanche = { lanchesPedidos: [ { id: 1, ingredientesNomes: ["OVO","HAMBURGUER","QUEIJO"] } ] };
      break;
    case 4:
      lanche = { lanchesPedidos: [ { id: 1, ingredientesNomes: ["BACON","HAMBURGUER","QUEIJO", "OVO"] } ]};
      break;
  }

  if (lanche.lanchesPedidos[0].ingredientesNomes.indexOf("ALFACE") > -1) {
    ingredientesAlface.css("visibility","visible");
  }
  if (lanche.lanchesPedidos[0].ingredientesNomes.indexOf("BACON") > -1) {
    ingredientesBacon.css("visibility","visible");
  }
  if (lanche.lanchesPedidos[0].ingredientesNomes.indexOf("HAMBURGUER") > -1) {
    ingredientesHamburguer.css("visibility","visible");
  }
  if (lanche.lanchesPedidos[0].ingredientesNomes.indexOf("QUEIJO") > -1) {
    ingredientesQueijo.css("visibility","visible");
  }
  if (lanche.lanchesPedidos[0].ingredientesNomes.indexOf("OVO") > -1) {
    ingredientesOvo.css("visibility","visible");
  }

var lancheJson = JSON.stringify(lanche);

(async () => {
  const rawResponse = await fetch('http://localhost:8080/lanchestotal', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    // mode: 'no-cors',
    body: lancheJson
  });
  const content = await rawResponse.json();

  console.log(content);
  $("#Preco").text(content.preco);
})();


})
