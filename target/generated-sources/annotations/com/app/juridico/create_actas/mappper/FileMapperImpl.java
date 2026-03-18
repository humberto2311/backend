package com.app.juridico.create_actas.mappper;

import com.app.juridico.create_actas.domain.entities.File;
import com.app.juridico.create_actas.infrastructure.dto.FileDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-18T01:18:52-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class FileMapperImpl implements FileMapper {

    @Override
    public FileDto toDto(File file) {
        if ( file == null ) {
            return null;
        }

        FileDto fileDto = new FileDto();

        fileDto.setId( file.getId() );
        fileDto.setFileName( file.getFileName() );
        fileDto.setFileType( file.getFileType() );
        fileDto.setFileSize( file.getFileSize() );
        fileDto.setSaveDate( file.getSaveDate() );
        fileDto.setObservations( file.getObservations() );
        fileDto.setPageCount( file.getPageCount() );
        fileDto.setUploadedBy( file.getUploadedBy() );

        return fileDto;
    }

    @Override
    public File toEntity(FileDto fileDto) {
        if ( fileDto == null ) {
            return null;
        }

        File file = new File();

        file.setId( fileDto.getId() );
        file.setFileName( fileDto.getFileName() );
        file.setFileType( fileDto.getFileType() );
        file.setFileSize( fileDto.getFileSize() );
        file.setSaveDate( fileDto.getSaveDate() );
        file.setObservations( fileDto.getObservations() );
        file.setUploadedBy( fileDto.getUploadedBy() );
        file.setPageCount( fileDto.getPageCount() );

        return file;
    }
}
