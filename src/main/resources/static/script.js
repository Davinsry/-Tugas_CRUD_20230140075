const API_URL = '/ktp';

$(document).ready(function() {
    loadKtp();

    // Handle form submission
    $('#ktp-form').on('submit', function(e) {
        e.preventDefault();
        saveKtp();
    });

    // Handle cancel button
    $('#cancel-btn').on('click', function() {
        resetForm();
    });
});

function loadKtp() {
    $.ajax({
        url: API_URL,
        method: 'GET',
        success: function(data) {
            const tableBody = $('#ktp-list');
            tableBody.empty();

            if (data.length === 0) {
                tableBody.append('<tr><td colspan="6" style="text-align: center;">Tidak ada data ditemukan</td></tr>');
            } else {
                data.forEach(ktp => {
                    tableBody.append(`
                        <tr>
                            <td>${ktp.nomorKtp}</td>
                            <td>${ktp.namaLengkap}</td>
                            <td>${ktp.alamat}</td>
                            <td>${ktp.tanggalLahir}</td>
                            <td>${ktp.jenisKelamin}</td>
                            <td>
                                <button onclick="editKtp(${ktp.id})" class="btn btn-sm btn-edit">Edit</button>
                                <button onclick="deleteKtp(${ktp.id})" class="btn btn-sm btn-delete">Hapus</button>
                            </td>
                        </tr>
                    `);
                });
            }
        },
        error: function(err) {
            showNotification('Gagal mengambil data: ' + (err.responseJSON?.message || 'Error Server'), 'error');
        }
    });
}

function saveKtp() {
    const id = $('#ktp-id').val();
    const ktpData = {
        nomorKtp: $('#nomorKtp').val(),
        namaLengkap: $('#namaLengkap').val(),
        alamat: $('#alamat').val(),
        tanggalLahir: $('#tanggalLahir').val(),
        jenisKelamin: $('#jenisKelamin').val()
    };

    const isUpdate = id !== '';
    const method = isUpdate ? 'PUT' : 'POST';
    const url = isUpdate ? `${API_URL}/${id}` : API_URL;

    $.ajax({
        url: url,
        method: method,
        contentType: 'application/json',
        data: JSON.stringify(ktpData),
        success: function(response) {
            showNotification(isUpdate ? 'Data berhasil diperbarui!' : 'Data berhasil ditambahkan!', 'success');
            resetForm();
            loadKtp();
        },
        error: function(err) {
            showNotification('Gagal menyimpan data: ' + (err.responseJSON?.message || 'NIK mungkin sudah terdaftar'), 'error');
        }
    });
}

function editKtp(id) {
    $.ajax({
        url: `${API_URL}/${id}`,
        method: 'GET',
        success: function(ktp) {
            $('#ktp-id').val(ktp.id);
            $('#nomorKtp').val(ktp.nomorKtp);
            $('#namaLengkap').val(ktp.namaLengkap);
            $('#alamat').val(ktp.alamat);
            $('#tanggalLahir').val(ktp.tanggalLahir);
            $('#jenisKelamin').val(ktp.jenisKelamin);

            $('#form-title').text('Edit Data KTP');
            $('#submit-btn').text('Update Data');
            $('#cancel-btn').show();
            
            $('html, body').animate({ scrollTop: 0 }, 'slow');
        },
        error: function(err) {
            showNotification('Gagal mengambil detail data', 'error');
        }
    });
}

function deleteKtp(id) {
    if (confirm('Apakah Anda yakin ingin menghapus data ini?')) {
        $.ajax({
            url: `${API_URL}/${id}`,
            method: 'DELETE',
            success: function() {
                showNotification('Data berhasil dihapus!', 'success');
                loadKtp();
            },
            error: function(err) {
                showNotification('Gagal menghapus data', 'error');
            }
        });
    }
}

function resetForm() {
    $('#ktp-id').val('');
    $('#ktp-form')[0].reset();
    $('#form-title').text('Tambah Data KTP');
    $('#submit-btn').text('Simpan Data');
    $('#cancel-btn').hide();
}

function showNotification(message, type) {
    const notification = $('#notification');
    notification.text(message);
    notification.removeClass('success error').addClass(type);
    notification.addClass('show');

    setTimeout(() => {
        notification.removeClass('show');
    }, 3000);
}
