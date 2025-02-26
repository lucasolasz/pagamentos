
$(document).ready(function () {
    // Exibe o Toast Mensagem automaticamente
    $('#toast').toast('show');

    // Ativar automaticamente o data-mask
    $('[data-mask]').each(function () {
        $(this).mask($(this).attr('data-mask'));
    });

    $('[data-readonly]').each(function () {
        $(this).css({
            'background-color': '#e9ecef', /* Cor padrão do disabled */
            'cursor': 'default', /* Mantém o cursor padrão */
            'color': '#6c757d', /* Cor do texto similar ao disabled */
            'border': '1px solid #ced4da', /* Borda padrão */
            'pointer-events': 'none' /* Impede interação, mas mantém a aparência */
        });
    });

    // Aplicar máscara e Datepicker a todos os campos com a classe .data-picker
    $(".datePicker").each(function () {
        $(this).datepicker({
            dateFormat: "dd/mm/yy",
            changeMonth: true,
            changeYear: true,
            yearRange: "1900:2100",
            regional: "pt-BR"
        });
    });


    $('.select2').select2({
        placeholder: "Selecione uma opção",
        theme: 'bootstrap4'
    });

});
