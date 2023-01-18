import {
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
  ViewChild,
} from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-message-modal',
  templateUrl: './message-modal.component.html',
  styleUrls: ['./message-modal.component.scss'],
})
export class MessageModalComponent implements OnInit {
  @ViewChild('modal', { static: true }) modal: any;
  @Input() title = '';
  @Input() message = '';
  @Input() icon = '';
  @Input() bntPrimary = '';

  @Output() clicked = new EventEmitter<any>();
  constructor(private modalService: NgbModal) {}
  ngOnInit(): void {
    this.open();
  }

  open() {
    this.modalService.open(this.modal, { animation: true, size: 'lg' });
  }

  closeModal() {
    this.modalService.dismissAll();
  }
}
