/** @type {import('tailwindcss').Config} */
module.exports = {
  prefix: 'tw-',
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      colors: {
        paleta: {
          cor1: '#540d6e',     /* roxo principal */
          cor2: '#a882dd',     /* lilás para decorações */
          cor3: '#69605c',     /* cinza para fontes em fundo branco e bordas */
          cor4: '#540d6e99',   /* roxo padrão semi-transparente */
          cor5: '#0dab76',     /* verde para botões de afirmação */
          cor6: '#d72638',     /* vermelho para warning e negative */
          cor7: '#000000',     /* preto */
          cor8: '#0000003f',   /* preto box-shadow */
          cor9: '#ffffff'      /* branco para fundo padrão */
        }
      },
    },
    plugins: [],
  }
}
