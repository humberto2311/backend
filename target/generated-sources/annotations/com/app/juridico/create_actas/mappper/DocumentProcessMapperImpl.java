package com.app.juridico.create_actas.mappper;

import com.app.juridico.create_actas.domain.entities.DocumentProcess;
import com.app.juridico.create_actas.infrastructure.dto.DocumentProcessDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-18T01:18:52-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class DocumentProcessMapperImpl implements DocumentProcessMapper {

    @Override
    public DocumentProcessDto toDto(DocumentProcess documentProcess) {
        if ( documentProcess == null ) {
            return null;
        }

        DocumentProcessDto documentProcessDto = new DocumentProcessDto();

        documentProcessDto.setState( documentProcess.isState() );
        documentProcessDto.setId( documentProcess.getId() );
        documentProcessDto.setDate( documentProcess.getDate() );
        documentProcessDto.setNames( documentProcess.getNames() );
        documentProcessDto.setLastNames( documentProcess.getLastNames() );
        documentProcessDto.setIdentity( documentProcess.getIdentity() );
        documentProcessDto.setConduct( documentProcess.getConduct() );
        documentProcessDto.setRadicado( documentProcess.getRadicado() );
        documentProcessDto.setFiscal( documentProcess.getFiscal() );
        documentProcessDto.setTypeAudience( documentProcess.getTypeAudience() );
        documentProcessDto.setFact( documentProcess.getFact() );
        documentProcessDto.setJuzgado( documentProcess.getJuzgado() );
        documentProcessDto.setNacion( documentProcess.getNacion() );
        documentProcessDto.setCaptura( documentProcess.getCaptura() );

        return documentProcessDto;
    }

    @Override
    public DocumentProcess toEntity(DocumentProcessDto documentProcessDto) {
        if ( documentProcessDto == null ) {
            return null;
        }

        DocumentProcess documentProcess = new DocumentProcess();

        if ( documentProcessDto.getState() != null ) {
            documentProcess.setState( documentProcessDto.getState() );
        }
        documentProcess.setId( documentProcessDto.getId() );
        documentProcess.setDate( documentProcessDto.getDate() );
        documentProcess.setCaptura( documentProcessDto.getCaptura() );
        documentProcess.setNames( documentProcessDto.getNames() );
        documentProcess.setLastNames( documentProcessDto.getLastNames() );
        documentProcess.setIdentity( documentProcessDto.getIdentity() );
        documentProcess.setNacion( documentProcessDto.getNacion() );
        documentProcess.setConduct( documentProcessDto.getConduct() );
        documentProcess.setRadicado( documentProcessDto.getRadicado() );
        documentProcess.setFiscal( documentProcessDto.getFiscal() );
        documentProcess.setTypeAudience( documentProcessDto.getTypeAudience() );
        documentProcess.setFact( documentProcessDto.getFact() );
        documentProcess.setJuzgado( documentProcessDto.getJuzgado() );

        return documentProcess;
    }
}
