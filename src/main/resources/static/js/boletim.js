document.getElementById('btnProxima').addEventListener('click', () => {
  document.getElementById('etapa-1').classList.remove('ativo');
  document.getElementById('etapa-2').classList.add('ativo');
  document.getElementById('rotulo-passo-1').classList.remove('atual');
  document.getElementById('rotulo-passo-2').classList.add('atual');
});

document.getElementById('btnVoltar').addEventListener('click', () => {
  document.getElementById('etapa-2').classList.remove('ativo');
  document.getElementById('etapa-1').classList.add('ativo');
  document.getElementById('rotulo-passo-2').classList.remove('atual');
  document.getElementById('rotulo-passo-1').classList.add('atual');
});

// Quando o campo CEP perde o foco, busca o endereço no ViaCEP
function buscarEndereco(valorCep) {
  const cep = valorCep.replace(/\D/g, '');
  console.log(cep)
  if (cep.length === 8) {
    fetch(`https://viacep.com.br/ws/${cep}/json/`)
      .then(response => response.json())
      .then(dados => {
        if (!dados.erro) {
          document.getElementById('logradouro').value = dados.logradouro;
          document.getElementById('bairro').value     = dados.bairro;
          document.getElementById('municipio').value  = dados.localidade;
          document.getElementById('estado').value     = dados.uf;
        }
      })
      .catch(err => console.error('Erro ao buscar CEP:', err));
  }
}
