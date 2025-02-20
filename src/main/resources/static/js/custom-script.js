
$(document).ready(function () {
    // Exibe o Toast Mensagem automaticamente
    $('#toast').toast('show');

    // Ativar automaticamente o data-mask
    $('[data-mask]').each(function () {
        $(this).mask($(this).attr('data-mask'));
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

});
